"""
CSCI-142 Computer Science 2 Recitation Exercise
01 - Java Intro
Polynomials

Write a program that reads a polynomial from the command line into a python
list (starting with the first term's coefficient).

There are three functions to perform operations on the polynomial once it is
in list form:
1. to_string - convert the polynomial list into a string
2. evaluate - evaluate the polynomial list for x=2
3. derivative - compute the derivative of the polynomial list

A sample run:
$ python3 poly.py 2 4 0 1 5
sys.argv: ['.../poly.py', '2', '4', '0', '1', '5']
poly_list: [2, 4, 0, 1, 5]
to_string: 5x^4 + 1x^3 + 4x + 2
evaluate(x=2): 98
derivative: 20x^3 + 3x^2 + 4
"""

import sys

def to_string(poly_list):
    """
    Convert a polynomial in a list into a string representation.
    For example:
        to_string([2, 4, 0, 1, 5]) -> '5x^4 + 1x^3 + 4x + 2'
    :param poly_list: the polynomial as a list
    :return: a string (str) of the polynomial
    """
    result = ''
    for i in range(len(poly_list)-1, -1, -1):
        # don't display a 0 coefficient
        if poly_list[i] != 0:
            result += str(poly_list[i])
            # don't display an x after the constant term
            if i > 0:
                result += 'x'
                # don't display the power for 1 or constant term
                if i > 1:
                    result += '^' + str(i)
            # display addition symbol if not last term
            if i > 0:
                result += ' + '
    return result

def evaluate(poly_list, x):
    """
    Evaluate the polynomial for a given x.
    :param poly_list:  the polynomial as a list
    :param x: the value of x to evaluate the polynomial for
    :return: the evaluation result (an int)
    """
    # store the result in a variable that starts at 0
    result = 0
    # loop over the polynomial from the first to last term and evaluate
    for i in range(0, len(poly_list)):
        # result += coefficient * (x^i)
        result += poly_list[i] * (x ** i)
    return result

def derivative(poly_list):
    """
    Compute the derivative of a polynomial.
    :param poly_list: the polynomial as a list
    :return: a new polynomial list (list) containing the derivative
    """
    # store the derivative polynomial in an initially empty list
    result = []
    if (len(poly_list) == 1):
        # if polynomial is constant, the derivative is 0
        result.append(0)
    else:
        # otherwise compute derivative using non-constant terms
        for i in range(1, len(poly_list)):
            result.append(poly_list[i] * i)
    return result

def main():
    """
    The main function reads the polynomial in from the command line
    into a python list and then calls several other functions to manipulate
    the polynomial.
    """
    if len(sys.argv) < 2:
        print('Usage: python3 poly.py term0 ...')
    else:
        print('sys.argv: ', sys.argv)
        # create an initially empty list for the polynomial
        poly_list = []
        # store the coefficients of the polynomial starting with the constant term.
        for i in range(1, len(sys.argv)):
            poly_list.append(int(sys.argv[i]))

        # call functions to manipulate the polynomial and display the results
        print('poly_list:', (poly_list))
        print('to_string:', to_string(poly_list))
        print('evaluate(x=2):', evaluate(poly_list, 2))
        print('derivative:', to_string(derivative(poly_list)))

if __name__ == '__main__':
    main()