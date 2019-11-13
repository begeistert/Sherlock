from sympy import *

class MathFunctions:
    var = Symbol('')
    value = 0

    def assignvalue(self, value):
        self.value = value

    def assignvariable(self, variable):
        self.var = Symbol(variable)

    def evaluate(self, funcion):
        return sympy.sympify(funcion).subs(self.var, self.value)
