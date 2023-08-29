import os 
with open("Current directory.txt", "w") as file:
  file.write(os.getcwd())
