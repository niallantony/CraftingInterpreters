CC = gcc
CFLAGS = -Wall -Wextra -std=c11 -g
TARGET = clox

SRC = main.c chunk.c debug.c compiler.c scanner.c memory.c value.c vm.c
OBJ = $(SRC:.c=.o)

$(TARGET): $(OBJ)
	$(CC) $(OBJ) -o $(TARGET)

%.o: %.c
	$(CC) $(CFLAGS) -c $< -o $@

clean:
	rm -f $(OBJ) $(TARGET)
