array = []

while True:
    user_input = input("Please enter all the elements. To stop, type 's': ")
    if user_input.lower() == 's':
        break

    try:
        number = int(user_input)
        array.append(number)
    except ValueError:
        print("Invalid input. Please enter a valid integer.")

current_max = -float('inf')

for num in array:
    if num > current_max:
        current_max = num

print(f"The maximum of the elements given in input is {current_max}")