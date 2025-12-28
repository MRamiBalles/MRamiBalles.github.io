import random
import numpy as np
import matplotlib.pyplot as plt
class Individual:
    def __init__(self, gene_length):
        self.genes = [random.random() for _ in range(gene_length)]
        self.fitness = 0

    def compute_fitness(self, datax, datay):
        m, b = self.genes
        self.fitness = sum([(y-(m*x+b)) ** 2 for x, y in  zip(datax, datay)])
    
    def mutate(self, mutation_rate):
        rand = random.random()
        if rand < mutation_rate:
            gene_to_mutate = random.randint(0, len(self.genes) - 1)
            self.genes[gene_to_mutate] += random.uniform(-1, 1)

    def crossover(self, other_, crossover_rate):
        # m1 = self.genes[0]
        # b1 = self.genes[1]
        # m2 = other.genes[0]
        # b2 = other.genes[1]
        # m1, b1 = m2, b2
        # self.genes = [m1, b1]
        rnd = random.random()
        if rnd < crossover_rate:
            other = other_.copy()
            gene_to_cross = random.randint(0, len(self.genes) - 1)
            self.genes[gene_to_cross] = other.genes[gene_to_cross]
        
def genetic_algorithm(datax, datay, gene_length, population_size, mutation_rate, crossover_rate, num_generations):
    population = [Individual(gene_length) for _ in range(population_size)]
    print(population)

X = np.linspace(-10, 10, 100)
Y = 2 * X + 3 + np.random.normal(0, 1, 100)

genetic_algorithm(
    datax = X,
    datay = Y,
    gene_length = 2,
    population_size = 100,
    mutation_rate = 0.2,
    crossover_rate = 0.2,
    num_generations = 100)

# plt.scatter(X, Y)
# plt.show()

individual = Individual(2)
individual.compute_fitness(X, Y)
print(individual.fitness)
print(individual.genes)

individual.mutate(1)
individual.compute_fitness(X, Y)
print(individual.fitness)
print(individual.genes)