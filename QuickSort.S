# See Instructions #2
.data ## Data declaration section
## String to be printed:
string_newline: .asciiz "\n" # newline character
string_space: .asciiz " " # space character
string_before: .asciiz "Before: "
string_after: .asciiz "After: "
array1:	.word 5, 8, 9, 1, 3, 4, 2 # array #1 to test quicksort !! this array will change when we are grading your assignment!
#array1:	.word 8, 9, 9, 1, 7, 5, 5 # array #1 to test quicksort !! this array will change when we are grading your assignment!

.text ## Assembly language instructions go in text segment

main: ## Start of code section

li $a1, 7 # C code: const int size = 7;
la $a0, array1
jal test_sort # C code: test_sort(arr, size);

li $v0, 10 # terminate program
syscall

print_array: # Function to print the contents of the array
# $a0 = memory address of the first element of the array
# $a1 = how many elements in the array

#calculate the array ending address
li $t1, 0 # $t1 is the index of the element we are accessing
move $t2, $a1
move $t0, $a0 # save the array memory address; $t0 is the array starting point
print_array_loop1:
    # print the integer at the address $a0
    li $v0, 1
    lw $a0, ($t0)
    syscall
    # print space character
    la $a0, string_space
    li $v0, 4
    syscall
    addi $t0, $t0, 4
    addi $t1, $t1, 1
    bne $t1, $t2, print_array_loop1
jr $ra  # Return back

test_sort: # Function to test the quick sort
# $a0 = memory address of the first element of the array
# $a1 = how many elements are in the array
# use the following saved registers:
# $s0 = memory address of the array
# $s1 = length of the array (number of elements)

# push $s0 and $s1 onto stack - because subroutine is not allowed to modify them

sw $s0, 0($sp)
addi $sp, $sp, -4
sw $s1, 0($sp)
addi $sp, $sp, -4


move $s0, $a0 # $s0 = memory address of the array
move $s1, $a1 # $s1 = length

la $a0, string_before # C code: printf("Before: ");
li $v0, 4
syscall

move $a0, $s0 # C code: print_array(arr, length);
move $a1, $s1

sw $ra, 0($sp)
addi $sp, $sp, -4

jal print_array

addi $sp, $sp, 4
lw $ra, 0($sp)

la $a0, string_newline # C code: printf("\n");
li $v0, 4
syscall

move $a0, $s0 # C code: quicksort(arr, 0, length - 1);
li $a1, 0
addi $a2, $s1, -1

sw $ra, 0($sp)
addi $sp, $sp, -4

jal quick_sort

addi $sp, $sp, 4
lw $ra, 0($sp)

la $a0, string_after # C code: printf("After: ");
li $v0, 4
syscall

move $a0, $s0 # C code: print_array(arr, length);
move $a1, $s1

sw $ra, 0($sp)
addi $sp, $sp, -4

jal print_array
addi $sp, $sp, 4
lw $ra, 0($sp)


la $a0, string_newline # C code: printf("\n");
li $v0, 4
syscall

# pop $s0 and $s1 from the stack

addi $sp, $sp, 4
lw $s1, 0($sp)

addi $sp, $sp, 4
lw $s0, 0($sp)

jr $ra # return


quick_sort: #Function to perform the quicksort algorithm
# $a0 = memory address of the first element of the array
# $a1 = left bound
# $a2 = right bound

# push $ra, $s0, $s1, $s2 onto stack
sw $ra, 0($sp)
addi $sp, $sp, -4
sw $s0, 0($sp)
addi $sp, $sp, -4
sw $s1, 0($sp)
addi $sp, $sp, -4
sw $s2, 0($sp)
addi $sp, $sp, -4

move $s0, $a0 # $s0 = memory address of the array
move $s1, $a1 # $s1 = left
move $s2, $a2 # $s2 = right

move $t1, $s2      # C code: int size = right
sub $t1, $t1, $s1  # C code: size -= left;
slti $t0, $t1, 1
beq $t0, 1, cleanup_quick_sort  # C code: if (size < 1) return;

# TODO
#    if (size == 1) {
#        if (arr[right] < arr[left]) {
#            temp = arr[right];
#            arr[right] = arr[left];
#            arr[left] = temp;
#        }
#        return;
#    }

# save pivot in $t1
move $t0, $s2      # C code: int index = right
add $t0, $t0, $t0  # C code: index += index  // double it
add $t0, $t0, $t0  # C code: index += index  // double it again
add $t0, $s0, $t0  # C code: index = arr + index
lw $t1, 0($t0)     # $t1 = arr[right]
# save the address of arr[right] in $t7
move $t7, $t0

# save the address of arr[left] in $t2
move $t0, $s1      # C code: int index = left
add $t0, $t0, $t0  # C code: index += index  // double it
add $t0, $t0, $t0  # C code: index += index  // double it again
add $t0, $s0, $t0  # C code: index = arr + index
move $t2, $t0      # $t2 = arr[left]

# save the address of arr[left] in $t3 (too)
move $t3, $t2  # C code: int* pi = &arr[left]

# that is:
# $t2 = &arr[left] = pi
# $t3 = &arr[wall] = pwall

# save the value of left in $t6
move $t6, $s1  # C code: int wall = left

loop:
    # load the value of arr[i] into $t4
    lw $t4, 0($t3)  
    slt $t0, $t1, $t4             # set $t0 to 1 if pivot < arr[i]
    beq $t0, 1, increment_loop    # if (pivot  < arr[i]) increment_loop
    beq $t1, $t4, increment_loop  # if (pivot == arr[i]) increment_loop

    beq $t2, $t3, increment_wall  # if (pwall == pi) increment_wall

    # swap the value of arr[wall] and arr[i]
    lw $t0, 0($t2)  # C code: temp = arr[wall]
    sw $t4, 0($t2)  # C code: arr[wall] = arr[i]
    sw $t0, 0($t3)  # C code: arr[i] = temp

    increment_wall:
    addi $t2, $t2, 4  # C code: pwall += 1
    addi $t6, $t6, 1  # C code:     i += 1

    increment_loop:
    addi $t3, $t3, 4  # C code:    pi += 1
    bne $t3, $t7, loop  # if (pi != pright) continue loop

lw $t0, 0($t2)  # C code: temp = arr[wall]
sw $t1, 0($t2)  # C code: arr[wall] = pivot
sw $t0, 0($t7)  # C code: arr[right] = arr[wall]

# prepare parameters to call quicksort(arr, left, wall - 1);
move $a0, $s0
move $a1, $s1
move $t0, $s2
addi $a2, $t6, -1
jal quick_sort

# prepare parameters to call quicksort(arr, wall + 1, right);
move $a0, $s0
move $a2, $s2
move $t2, $t0
addi $a1, $t6, 1
jal quick_sort

cleanup_quick_sort:

# pop $s0, $s1, $s2, $ra from the stack

addi $sp, $sp, 4
lw $s2, 0($sp)
addi $sp, $sp, 4
lw $s1, 0($sp)
addi $sp, $sp, 4
lw $s0, 0($sp)
addi $sp, $sp, 4
lw $ra, 0($sp)

jr $ra
