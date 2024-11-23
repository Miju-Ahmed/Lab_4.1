    .data                           // Data section
roll_numbers: 
    .word 101, 102, 103, 104, 105   // Roll numbers of the team leaders

    .text                           // Code section
    .global main                    // Entry point for the program
main:
    LDR R0, =roll_numbers           // Load the address of the roll_numbers array into R0
    LDR R1, [R0]                    // Load the first roll number into R1
    LDR R2, [R0, #4]                // Load the second roll number into R2
    LDR R3, [R0, #8]                // Load the third roll number into R3
    LDR R4, [R0, #12]               // Load the fourth roll number into R4
    LDR R5, [R0, #16]               // Load the fifth roll number into R5

end: 
    B end                           // Endless loop to stop execution
