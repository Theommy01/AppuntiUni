import random
import threading
import time


def threadsfun(thread_id):
    # Greeting message
    print(f"Hi, I’m thread {thread_id}")

    # The thread sleeps for a random amount of time, i.e. between 1 and 5 seconds
    # (The amount of time has been chosen for test management only. It can be even for some minutes)
    sleep_time = random.randint(1, 5)
    time.sleep(sleep_time)

    # Farewell message
    print(f"Thread {thread_id} slept for {sleep_time} seconds.")

# Create a list of 3 threads
threads = []
for i in range(1, 4):
    thread = threading.Thread(target=threadsfun, args=(i,)) # New thread
    threads.append(thread) # Add it to the list
    thread.start() # Start new thread's execution

# Wait for all threads to end their execution
for thread in threads:
    thread.join()

print("All threads have finished.")