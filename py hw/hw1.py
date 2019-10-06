# CS1210 HW1
#
# I certify that this file contains only my own work. I also certify
# that I have not shared the contents # of this file with anyone in 
# any form.

######################################################################
# Edit the following function definition, replacing the word
# 'hawkid' with your own hawkid.
#
# Note: Your hawkid is the login name you use to access ICON, and not
# your firsname-lastname@uiowa.edu email address.
#
# YOU MUST ENTER YOUR HAWKID TO GET CREDIT FOR THIS HOMEWORK
# ASSIGNMENT.  CAVEAT EMPTOR.
#
def hawkid():
    return(["mkemp4"])

######################################################################
# You will likely require one or more functions from the random module.
from random import *

######################################################################
# Specification: new(N, k) creates a representation of a fresh Eson
# Xorgol board consisting of N pits, conceptually arranged in two rows
# of N/2 pits each. Each pit initially contains k playing pieces.
#
# We will represent our board as a list of N elements, each
# initialized to the integer k. Your implementation should force N to
# be even; if an odd N is provided, it should be treated as N-1. Your
# implementation should also only accept k > 0; in the event k is 0 or
# less, you should return False. So:
#   >>> new(10, 3)
#   [3, 3, 3, 3, 3, 3, 3, 3, 3, 3]
#   >>> new(7, -2)
#   False
#   >>> new(7, 2)
#   [2, 2, 2, 2, 2, 2]
#
##redo
def new(N, k):
    if(N % 2 == 0 and k > 0):
        return[k for c in range(N)]
    elif(N % 2 != 0 and k > 0):
        return[k for c in range(N-1)]
    else:            
        return False
    #return((if(N%2!=0):

######################################################################
# Specification: show(B) produces a printed representation of B, a Eson
# Xorgol board represented as a list of integers. The function should
# return None.
#
# Although the board B is really just a list of integers, it should be
# conceptually interpreted as two rows of pits, where the ith pit contains
# a number of playing pieces equal to the value of the ith element of
# the list.
#
# We'll index the board representation starting with pit 0 at the top
# left with subsequent pits arranged in clockwise order. Here is an
# example of the indexing scheme for an N=10 Eson Xorgol board:
#   0 1 2 3 4
#   9 8 7 6 5
#
# Of course in the actualy printed representation, we're interested in
# both the number of pieces contained in each pit as well as the index
# of the pit (for reasons that will become clear shortly). So, for
# example:
#   >>> show(new(10, 9))
#       0   1   2   3   4 
#     ---------------------
#     |  9|  9|  9|  9|  9|
#     ---------------------
#     |  9|  9|  9|  9|  9|
#     ---------------------
#        9   8   7   6   5 
#   >>> show(new(7, 2))
#        0   1   2 
#     -------------
#     |  2|  2|  2|
#     -------------
#     |  2|  2|  2|
#     -------------
#        5   4   3 
# Note how the indeces are shown outside of the board, with the
# number of pieces in each pit displayed in the corresponding pit
# position.
#
#check for better solutions
def show(B):
    for i in range(4):
        if(i == 0):
            top = "";
            for j in  range(len(B)/2):
                top = top + "   " + str(j)
            print(top)
            print("-"*(2*len(B)) + ("-"))
        elif(i == 1):
            row = "|"
            for j in range(len(B)/2):
                row = row + "  "+str(B[j*i])+"|"
            print(row)
            print("-"*(2*len(B)) + ("-"))
        elif(i==2):
            row = "|"
            for j in range(len(B),len(B)/2,-1):
                row = row + "  "+str(B[j-1])+"|"
            print(row)
        else:
            print("-"*(2*len(B)) + ("-"))
            bottom = "";
            for j in  range(len(B),len(B)/2,-1):
                bottom = bottom + "   " + str(j-1) 
            print(bottom)
                

######################################################################
# Specification: Return a list of non-empty pit indeces for given
# board B.
def legal(B):
    return[c for c in range(len(B)) if B[c] != 0]

######################################################################
# Specification: Choose a random legal move for board B; returns the
# index of the selected pit.
def chooseRandom(B):
    return[(legal(B)[int(random()*len(legal(B)))])]

######################################################################
# Specification: Ask the user to select a move for given board B:
# return the selected pit index.
def chooseHuman(B):
    answer = ""
    k = False
    while(k == False): 
        answer = input(("Select a non-empty pit" + str(legal(B))+": "))
        if(int(answer)in legal(B)):
            k = True
        else:
            print("input not in list")

    return int(answer)
            
    
    

######################################################################
# Specification: Choose "best" move for given board B: returns the
# selected pit index.
def chooseBest(B):
    pass

######################################################################
# Specificiation: takes a board, B, and distributes contents of pit i
# clockwise around board B. Check resulting board for capture
# condition, and if a capture occurs, return the number of pieces
# captured while being sure to remove those pieces from the board
# itself. If no capture occurs, return 0.
def sow(B, i):
    pass

######################################################################
# Game driver.
def play(N=10, k=9, player=[chooseHuman, chooseRandom]):
    B = new(N, k)
    score = [ 0 ]*len(player)
    turn = 0
    draw = N*2
    while(sum(B) > 1 and draw > 0):
        show(B)
        print("Player {} to play.".format(turn))
        capture = sow(B, player[turn](B))
        if capture > 0:
            print("Player {} earns {} point(s)".format(turn, capture))
            score[turn] = score[turn] + capture
            draw = N*2
        else:
            draw = draw - 1
        turn = (turn+1)%len(player)
    print("Game over: {}".format(score))
    return(score)
