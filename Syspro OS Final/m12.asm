MACRO
COPY &ONE,&TWO,&REG2=BREG
MOVER &REG2 &ONE
MOVEM &REG2 &TWO
MEND
MACRO
CHANGE &FIRST,&SECOND,&REG1=AREG,&OP=ADD
MOVER &REG1 &FIRST
&OP &REG1 &SECOND
MOVEM &REG1 &FIRST 
MEND
READ A
COPY A,B
CHANGE A,B,REG1=CREG
COPY A,C
CHANGE C,B,OP=SUB,REG1=DREG
PRINT A
PRINT B
PRINT C
STOP
A DS 1
B DS 1
C DS 1
END
