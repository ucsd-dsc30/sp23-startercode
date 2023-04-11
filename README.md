# PA 2: Queue and JUnit Testing

**You are allowed to work with one more person on this PA.**  
Final submission due: 04/17 (Monday) 11:59 pm  
Checkpoint submission due: 04/14 (Friday) 11:59 pm  
100 points + 5 extra points (Checkpoint submission)  

### Overview

In this assignment, we will implement a circular queue and test its behavior using JUnit testing. Then we will use a queue to translate a given DNA to a protein sequence. 

**This assignment is a GROUP assignment (no more than two per group).** You may ask Professors/TAs/Tutors for some guidance and help, but you can’t copy code. You may discuss the assignment conceptually with your classmates, including bugs that you ran into and how you fixed them. **However, do not look at or copy code.** This constitutes an Academic Integrity Violation.

### Group Assignment Tips

This is the first group assignment of the course. We encourage you and your partner to exchange thoughts, resolve potential misconceptions, and come up with a common solution. There are several tools that allow engaging discussions and collaborating in a live setting, such as sharing screens and coding together on zoom. We strongly recommend you to utilize these features. Last but not least, if you and your partner are coding independent sections, make sure to update your progress among each other and merge your code earlier to avoid large disparities in code bases.

## **START EARLY!**

### Checkpoint Submission

Similar to DSC 20, you can gain at most 5 points extra credit by making a checkpoint submission. The checkpoint submission is graded by completion, which is measured by some simple tests. In your final submission, you can modify the checkpoint part if necessary.

**Files to submit for the checkpoint (04/14):**
- `CharQueue.java`
- `CharQueueTest.java`   (the exception part is not required)
  - With at least 3 assertions for each implemented method. You can add more later.
  
## Part 1 - Setup

### Part 1.1 Starter Code

StarterCode is available [here](https://github.com/ucsd-dsc30/sp23-startercode/tree/PA2). You may follow the same setup from PA1 or the [alternative setup here](https://docs.google.com/document/d/1MUlSsdDDu950wQEiEsWRqDBB2YpP3Gy4WiE_YFehux4/edit#heading=h.xgv7h04ga306) (which you might find quicker). **Even if you’re using the same setup, make sure to look at the setup guide given the structural changes made in the startercode repository.**

### Part 1.2 Style Requirements
Total: 10 Points

**Style Requirements**

You will be graded on your code’s style based on the [style guide](https://dsc-courses.github.io/dsc30-2023-sp/styleguide/). Note that there are style considerations beyond indentation and such:
- Choose names for test methods and for variables that are descriptive and useful when you see them in the test output.
- Consider writing helper methods if you repeatedly use the same set of statements.
- Use Javadoc comments for descriptions of your methods and classes and inline comments if the logic of your program is not captured by your variable names and the natural flow of code. **Please do not comment on every line, your variables should be descriptive enough.**

## Part 2 - Resizable Queue

### Part 2.1 - Implementation

Recall that a queue is an abstract data type (ADT) that allows a limited number of operations on a collection of data. Elements are stored and removed in First-In-First-out (FIFO) order. In Part 2 you will create a class called `CharQueue`, which will implement a circular queue that stores characters only.  We will use an array as the underlying data structure, where front and rear indices will be managed using a circular approach (more on that below).

**Circular Queue**

Let’s understand the idea of the circular queue first (please refer to the lecture as well). 

- We need to keep track of the front and rear of the queue and update them as you add and remove elements. This way, we immediately know the location to add or remove an element without having to search or traverse.
- We will use a **circular array** as the backing storage. Why?
  - it allows for efficient use of memory, as it can reuse the space that was previously occupied by deleted elements. Circular arrays are commonly used in applications that require the continuous processing of data, such as audio and video streaming, and in implementing data structures like circular queues and circular buffers. 

Let’s see how they work. A circular queue uses a fixed-length array and uses two pointers or indices, front (F) and rear (R) to keep track of the start and end of the queue. If we start with the empty queue, then front (F) and rear (R) indices will be initialized to a 0. With each enqueue, R is incremented by one. With each dequeue F is incremented by one. This behavior is illustrated below (With E representing empty elements/containers). 

![image](https://user-images.githubusercontent.com/50224596/231067129-25e31f82-e133-4da6-b90d-ba9866c7c751.png)

Notice, the left side of the array remains empty and the more enqueues and dequeues we perform, the longer this empty part becomes, wasting space. The solution to this issue is when F and/or R reach the end of the array, they wrap around back to the 0th element.

![image](https://user-images.githubusercontent.com/50224596/231067427-1d050694-1809-4fa8-9a04-91d5011f332a.png)

**Expand Capacity**

Since we are using an array, which is a fixed size data structure, to implement a queue, it will eventually reach maximum capacity after enough elements are added. However, the queue should be able to accommodate any number of elements. That is, regardless of your queue’s initial capacity, a call to `enqueue(char elem)` will always successfully add an element to your queue. Thus, **once the array that backs your queue becomes FULL, you will need to resize it, resizing should take O(n) time.**

**Steps to take:** when expanding the capacity of your Queue, you will need to do the following:
- Allocate a new, larger array (doubled in size).
- Copy the elements from your old array to this new array while maintaining the order of the elements (do not forget to update the Front and Rear indices). Make sure that you take into account that the front and rear pointers may not be at the same points and some shifting of elements may be necessary. 
- Change the references. Make sure that your queue’s circular array is now bound to this new one with a larger capacity.

You will find it useful to use the % (modulo) operator which will return the remainder of the division x%y = r of x/y. For example, 5 % 3 = 2 (*5 divided by 3 results in a remainder of 2*). Think about how you can use this when writing your circular array.

**Implementation**

You will be implementing the following methods, **all queue methods should be O(1), except when expanding the queue is required, expanding the queue will take O(n) time:**

| Constructors and methods to implement in CharQueue.java |
| --- |
|`public CharQueue()` <br> <br>Creates a new queue with an initial capacity of 5.<br>**Note:** You can call other constructors using method *this()*. |
|`public CharQueue(int capacity)` <br> <br>Creates a new queue with the specified capacity.<br> <br>`@throws IllegalArgumentException`<br>if `capacity` is out of valid range (i.e. less than 1)|
|`public boolean isEmpty()` <br><br>Checks if the queue is empty. Returns `true` if it is empty, `false` otherwise. |
|`public int size()` <br><br>Returns the number of elements currently stored in the queue |
|`public void clear()` <br><br>Clears all elements in the queue.<br>**Hint:** This method is O(1) and no loops are needed. |
|`public void enqueue(char elem)` <br> <br>Adds a new `elem` to the back of the queue. Increase the capacity of the queue **before** adding the `elem` if the maximum capacity is reached.|
|`public char peek()` <br><br>Returns the element at the front of the queue. <br><br>`@throws NoSuchElementException` <br>if the queue is empty|
|`public char dequeue()` <br><br>Returns and removes the element at the front of the queue. <br><br>`@throws NoSuchElementException` <br>if the queue is empty |

In addition, you may use any private helper methods that you deem necessary.

**Example Behavior**

![image](https://user-images.githubusercontent.com/50224596/231069708-fa8c2c4d-adb3-4a8e-9866-989037a27a3f.png)

### Part 2.2 - JUnit Testing

For this part, you must use JUnit to test your code. Create a **JUnit 5** test file called **CharQueueTest.java**, and include at least **3 assertions** (tests) for each constructor and methods. In addition to that, you should test all possible cases that throw an exception. For test files, we will not grade on style, so you don’t need to worry about style requirements like magic numbers, comments and headers. This test file will be a part of your submission.

To assert for an exception, you can use the following piece of code:

```
Assertions.assertThrows(ArithmeticException.class, () -> {
        // code that is expected to throw the exception
});
//Replace “ArithmeticException” with the type of exception you are expecting
```

This assert will pass when the specified exception is thrown, and will fail otherwise. 

**Some suggestions for testing are:**
- Remove an element from an empty queue.
- Add many elements into a queue, ensuring that the queue contains the enqueued elements in the proper order.
- Add and remove elements from a queue multiple times.
  - Your unit tests can make use of loops. They are functions after all. 
- **Don’t stop here; think of more test cases.** Try out cases that will potentially fail on your implementation. (This is what we will try to do on our end. Don’t let us win.)

For info on how to set up JUnit5, [refer to this guide](https://docs.google.com/document/d/1y65SWnaUOjClGPwliWOd_uyXe05TezFYjmzvPs19cUY/edit).

# Part 3 - Queue Practical Application: DNA Transcription & Translation

### Part 3.1 - Implementation

In this part you are going to use your queue created in Part 2 and perform a DNA to a protein sequence. This process takes two steps:  DNA [transcription](https://www.google.com/search?q=DNA+transcription&spell=1&sa=X&ved=2ahUKEwiA48mN4vr9AhVMIUQIHRQNCUkQkeECKAB6BAgIEAE) and mRNA translation. Although you are not required to understand the details behind the process, it may be beneficial to have a basic understanding of the process.

- DNA is short for Deoxyribonucleic Acid, which is a special molecule found inside almost every living thing on Earth. It is made up of different sections called "genes”. Each gene tells the cell how to make a specific protein, which is a type of molecule that performs a specific job in the body. Proteins help our bodies do things like digest food, move our muscles, and even think and feel emotions. **The information stored in DNA is recorded as a sequence of four different chemical building blocks,** called *nucleotides*, which are abbreviated as **A(**Adenine**)**, **T(**Thymine**)**, **C(**Cytosine**)**, and **G(**Guanine**)**. The order of these nucleotides determines the genetic code.
  
  **For example:**
  
  ATCATGCGTTAGACC
  
- RNA is a molecule that is very similar to DNA, but it is single-stranded and contains a slightly different type of nucleotide: U(Uracil) instead of T(Thymine).  We need to transcribe DNA to RNA, because RNA serves as a template for the synthesis of proteins, which are the building blocks of all living organisms. During transcription, the RNA polymerase enzyme reads the DNA sequence and creates a complementary RNA copy. This RNA copy, called messenger RNA (mRNA), is then transported out of the nucleus and into the cytoplasm, where it serves as a blueprint for protein synthesis.
  
  **For example:**
  
  The corresponding mRNA for the DNA above is AUCAUGCGUUAGACC  (Each T is replaced with U)
  
- Translation is the process by which the information stored in the sequence of nucleotides in mRNA is used to create a chain of amino acids that will fold into a functional protein. During translation, the ribosomes read the mRNA in a sequence of three nucleotides, called a codon. Each codon corresponds to a specific amino acid, which is the building block of proteins.. Thus, translating mRNA means reading the sequence of nucleotides in mRNA to create a chain of amino acids that will fold into a functional protein during the process of translation. The RNA translation start symbol is represented by the codon AUG and stop codons are UAA, UAG, and UGA.
  
  Nucleotides are translated according to this table **AND SIMPLIFIED TO A SINGLE LETTER (FOUND IN STARTER CODE ‘CodonMap.java’):**
  
  ![image](https://user-images.githubusercontent.com/50224596/231071099-b73f72d5-6836-46ae-bddc-79c9d4084238.png)

**For example:**

For the mRNA above we have groups of three nucleotides, codons. Once we see a starting codon, the translation begins; and we stop one we reach a stopping codon.. There is a mapping between codons and amino acids. For example, the codon represented by UUU refers to Phenylalanine. 

Given an the following mRNA:

AUC**AUG**CGU**UAG**ACC

The resulting protein is MR*  Here, the * indicates that one of the ending codons was found. 

Optional but a bit in depth reading about the process: [Link](https://towardsdatascience.com/starting-off-in-bioinformatics-turning-dna-sequences-into-protein-sequences-c771dc20b89f?gi=fd42d0579235)

**Translation High Level Overview**
1. Define a dictionary that maps each possible codon (sequence of three nucleotides) to its corresponding amino acid.
2. Divide the RNA sequence into groups of three nucleotides (codons).
3. Look up each codon in the dictionary to find the corresponding amino acid.
4. Append each amino acid to a growing protein sequence.
5. Stop when reaching the end of the RNA sequence or a stop codon (UAA, UAG, or UGA).
6. Return the protein sequence.

**For example:** (transcribe & translate)

![image](https://user-images.githubusercontent.com/50224596/231092007-dc6ef3ba-d6f7-4bec-8900-ff54828ed0c8.png)

![image](https://user-images.githubusercontent.com/50224596/231092825-d0cb5123-0003-4153-a299-25d8bb344bcb.png)

Now let us put everything together. In a new class called ProteinSynthesis,  implement two functions described above.

| Constructors and methods to implement in ProteinSynthesis.java |
| --- |
| No constructors for this class are needed |
| `public CharQueue transcribeDNA(String dna)` <br><br> Creates an RNA by replacing each occurrence of ‘T’ with ‘U’, saves the result in a queue and returns it. <br><br> `@throws IllegalArgumentException`<br>If the length of the input is not divisible by 3.|
| `public CharQueue translateRNA(CharQueue rna)` <br><br> Translates a given RNA to a protein. Starts the translation when codon “AUG” is found and stops when:<ul><li> The sequence is over or </li><li>One of the three stopping codons is read: “UAA”, “UAG”, or “UGA”</li></ul>If no “AUG” is found then return an empty queue. <br><br> **Note:** We provide a function `getAminoAcid` (can be found in CodonMap class). This function takes a string with three characters (a codon) and returns a corresponding AminoAcid. |

### Part 3.2 JUnit Testing

In order to test your code create a **JUnit 5** test file called `ProteinSynthesisTest.java` and include at least **3 assertions** (tests) for each constructor and methods. It is highly recommended for you to add more tests with different input sizes. In addition to that, you should test all possible cases that throw an exception.

**Suggestions:**
- You can use random DNA generator tool: [Link](https://faculty.ucr.edu/~mmaduro/random.htm)
- You can also use this tool to check your answer. Make sure to mark start and stop codons option: [Link](https://biomodel.uah.es/en/lab/cybertory/analysis/trans.htm) 
  - It is not perfect though, you may have to clear and re-run it a few times to get the answer we need.
  
 ### Submission
 
**Checkpoint Submission (Optional, Extra Credit):**  
**Files to submit:**
- `CharQueue.java`        (the exception part is not required)
- `CharQueueTest.java`    (the exception part is not required)

**Final Submission:  
Make sure all files are in src/ folder!  
Files to submit (5)**  
- `CharQueue.java`
- `CharQueueTest.java`
- `ProteinSynthesis.java`
- `ProteinSynthesisTest.java`

**After you submit your files to GradeScope, wait for the output of the submission script. Make sure you see this after your submission:**

```
THIS IS A SUCCESSFUL SUBMISSION. YOUR SCORE WILL BE UPDATED ONCE GRADED.
```

**Otherwise, please fix the error and resubmit your files.**
