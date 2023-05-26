
import numpy as np
import multiprocessing as mp

def calculate_sum(array):
    partial_sum = np.sum(array)
    return partial_sum

if __name__ == '__main__':
    num_processes = mp.cpu_count()  # Number of available processes/threads
    print("Enter size of array")
    array_size = int(input())  # Size of the input array
    array = np.arange(1, array_size + 1)  # Input array
    print("Input Array:", array)
    # Divide the array into equal chunks for each process
    chunk_size = array_size // num_processes
    chunks = [array[i:i+chunk_size] for i in range(0, array_size, chunk_size)]

    # Calculate partial sums using OpenMP
    with mp.Pool(processes=num_processes) as pool:
        partial_sums = pool.map(calculate_sum, chunks)

    # Display intermediate sums calculated at different processes
    for i, partial_sum in enumerate(partial_sums):
        print(f"Process {i}: Partial Sum = {partial_sum}")

    # Calculate the final sum by combining the partial sums
    total_sum = np.sum(partial_sums)

    print("Total Sum:", total_sum)
