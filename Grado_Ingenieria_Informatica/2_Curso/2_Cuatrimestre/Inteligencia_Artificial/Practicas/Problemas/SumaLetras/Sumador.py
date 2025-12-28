class Variable:
    def __init__(self, name):
        self.name = name
        self.value = -1

class Puzzle:
    def __init__(self):
        self.variables = [
            Variable("S"),
            Variable("E"),
            Variable("N"),
            Variable("D"),
            Variable("M"),
            Variable("O"),
            Variable("R"),
            Variable("Y")
        ]
        self.solutions = set()

    def is_digit_used(self, digit):
        return any(var.value == digit for var in self.variables)

    def is_valid_assignment(self):
        used_digits = set()
        for var in self.variables:
            if var.value != -1 and var.value in used_digits:
                return False
            used_digits.add(var.value)
        return True

    def check_solution(self):
        send = self.variables[0].value * 1000 + self.variables[1].value * 100 + self.variables[2].value * 10 + self.variables[3].value
        more = 1000 + self.variables[5].value * 100 + self.variables[6].value * 10 + self.variables[1].value
        money = 10000 + self.variables[5].value * 1000 + self.variables[2].value * 100 + self.variables[1].value * 10 + self.variables[7].value
        return send + more == money

    def print_solution(self):
        solution_str = "  {} {} {} {}\n+ {} {} {} {}\n---------\n{} {} {} {} {}".format(
            self.variables[0].value, self.variables[1].value, self.variables[2].value, self.variables[3].value,
            1, self.variables[5].value, self.variables[6].value, self.variables[1].value,
            1, self.variables[5].value, self.variables[2].value, self.variables[1].value, self.variables[7].value
        )
        if solution_str not in self.solutions:
            print(solution_str)
            self.solutions.add(solution_str)
            print("")

    def backtrack(self, index):
        if index == len(self.variables):
            if self.check_solution():
                self.print_solution()
            return

        var = self.variables[index]
        for digit in range(10):
            if not self.is_digit_used(digit):
                var.value = digit
                if self.is_valid_assignment():
                    self.backtrack(index + 1)
                var.value = -1

    def solve(self):
        self.backtrack(0)

# Iniciar la resolucion del puzzle
puzzle = Puzzle()
puzzle.solve()

