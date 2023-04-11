# PA 1: Intro to Java

Due: April 10th, Monday, 11:59 pm  
100 points + 10 extra credit

### Overview

For the first assignment, you will begin by setting up your development environment for the rest of the quarter. We will be programming in Java using IntelliJ as our IDE. Additionally, we will use Git to handle version control. 

**This assignment is an individual assignment.** You may ask Professors/TAs/Tutors for some guidance and help, but you can’t copy code. You may discuss the assignment conceptually with your classmates, including bugs that you ran into and how you fixed them. **However, do not look at or copy code.** This constitutes an Academic Integrity Violation.

For this quarter, some TA/tutors will **offer their office hours online.** Please read this [guide](https://docs.google.com/document/d/19OJNAxu0gALS7mSCBzuGXrRu7eG7LPevDZCWu7AF998/edit) for how to get help from these online office hours.

## **START EARLY!**

## Part 0 - Agreement and Quiz 0  
Total: 2 points

1. **Integrity of Scholarship Agreement (1 point)**

    Before starting the homework, please carefully read and fill out the [integrity of the scholarship agreement form](https://docs.google.com/forms/d/e/1FAIpQLSfFYuTO6a2bMd8f6-ULGj5qvqhgG--jeTRlY7hcAQaY3XXVlg/viewform). You will not receive scores in this class until you submit the form.

2. **Quiz 0 (1 point)**

    Log in to Canvas and take Quiz 0. Make sure you understand how to find and take it. All reading quizzes will be there (unless zybook activity is assigned). The deadline for this quiz is the same as PA 1’s deadline.

## Part 1 - Setup
Total: 4 points

1. Git ;)

    In this course, we will enforce usage of Github to submit your assignment on gradescope. [Please follow this guide to set up your git repo](https://docs.google.com/document/d/1jiwu3nmTu0yvgMCD3n7LCk4PrOF_gh5xp-EmdupaWhk/edit). 

2. IntelliJ

    Install IntelliJ from [JetBrains](https://www.jetbrains.com/idea/download/#section=linux).  
    This will be your IDE (*Integrated Development Environment*) for DSC30, where you write and run Java programs. We will use the **community edition.** You can keep the default settings during the installation.

    During your first run, you will be prompted to select a theme, choose keymaps, create a launcher script, and choose plugins. Either theme is fine. You can use the default settings when choosing the keymaps and leave the launcher script section blank. By default, the necessary plugins are enabled, but at the minimum, you will need:

    - Build Tools
        - Ant
    - Version Controls
        - Git
    - Test Tools
        - JUnit

    Since you will be graded on style, you can also install a [plugin](http://sp17.datastructur.es/materials/guides/plugin.html) to check your style. This recommended plugin comes courtesy of UC Berkeley’s CS 61B course but will work for DSC 30.

3. Put your IntelliJ Project into the git repository

    If you haven’t done so, move the folder that contains the IntelliJ project under the git repository directory. Make sure you add, commit, and push the IntelliJ project to the github accordingly.

4. Hello World

    Please [refer to this link](https://docs.google.com/document/d/1jiwu3nmTu0yvgMCD3n7LCk4PrOF_gh5xp-EmdupaWhk/edit#heading=h.uenu27n5rsgj) (same link as git setup guide) and complete the `HelloWorld.java` file. You will have to submit it as a part of your PA.

## Part 2 - Basic Java Programming Challenges

**First, look over the [Java crash course](https://docs.google.com/document/d/1T28yJoqQlJuVopZjdPOc7Irnpwz5vgTJcRBrpksChCU/edit#heading=h.9lvn0z95r3hv).** You might want to use it as a reference for your future PAs. For details on how to read Java documentation and utilize corresponding methods, please refer to the [java documentation guide](https://docs.google.com/document/d/1Q8VuA7_G_slTEI9urIoglYsX4Clw5V-wBoaK6EluYrM/edit).

### Style Requirements  
Total: 10 Points

You will be graded for the style of programming on every assignment. **Each assignment will have about 10 points just for the style of your code, so make sure you read through this part and strictly follow the style requirements when writing your PAs.** [You may find the style guide on the course website](https://dsc-courses.github.io/dsc30-2023-sp/styleguide/).

This is a complete Java style guide: [Java Style Guide](https://sp18.datastructur.es/materials/guides/style-guide.html) written by Alan Yao from UC Berkeley.

### Implement methods in Java

Now that you have learned how to create and run a simple program in Java using IntelliJ, make a new class called `ProgrammingChallenges` in your PA1 project. (Just like how you created the `HelloWorld` class). 

For the class `ProgrammingChallenges`, **you aren’t allowed to import Java packages.** Also, you may assume that all **parameters will not be null.** When you write the methods, make sure your method signature is exactly the same as in the write-up, otherwise, you might lose points for this question since the autograder cannot find the method. 
- Whenever there are questions that require a number to be rounded to some decimal places, please use `String.format` instead of `DecimalFormat`.
- You should use a main method and print statements in order to test your code. We will learn a better way to test your code soon. 


### Starter Code

[Starter Code can be found at this link](https://github.com/ucsd-dsc30/sp23-startercode). You can use the git skills you just learned to clone this repository into your own computer. You’ll clone the starter code repository first, and copy ProgrammingChallenges.java (in the cloned repo) into the src folder of the IntelliJ project - the same location where `HelloWorld.java` is created. Note that you should not clone the starter code repository within your IntelliJ project nor within the dsc30-pa1 repo. 

Alternatively, for PA1 specifically you can [access the StarterCode at this link](https://drive.google.com/drive/folders/1lLhd9hN2Y_2sre3dbpz6fuH-oayM1Bjq). For future PAs you will be required to fetch the StarterCode at the GitHub repository.

Write the following methods inside class `ProgrammingChallenges`:

> Problem 1 (Purpose: Boolean Operators)

```
// 1
public static boolean store(String item, float inWallet, float needed)
```

You decided to celebrate the beginning of the quarter and went to the store to buy something tasty. You have some cash in your wallet and there is also an amount that you must pay at the store. Write a method that returns true when the item is equal to “cake”, “ice-cream”, or “sushi” and you have enough money in your wallet. 

**Example: (notice how we denote a float here)**

```
Input: sushi, 4.4f, 5.43f
Output: false  

Input: rice, 100f, 5f
Output: false  

Input: ice-cream, 100f, 5f 
Output: true  

Input: ice-cream, 5f, 10.5f 
Output: false
```

> Problem 2. (Array manipulations, no loop)

```
// 2
public static boolean compareArrays(int [] arr1, int [] arr2)
```

Given two integer arrays, with length 1 or more. Write a method that returns true when:
- Both arrays have different lengths and
- The first element of the first array is the same as the last element of the second array and
- The last element of the first array is the same as the first element of the second array.  

Return false otherwise. 

**Example:**

```
Input: [1, 3, 4], [2, 4, 6] 
Output: false  

Input: [1, 3, 4], [4, 4, 6, 1]
Output: true

Input: [1, 3, 4], [4, 4, 1]
Output: false
```

> Problem 3. (Purpose: Single for loop and array practice)

```
// 3
public static int countNumbers(int [] arr1)
```

Given one integer array. Write a method that counts:
- The number of even numbers NOT divisible by 3. 

**Example:**

```
Input: [1, 3, 4] 
Output: 1  

Input: [4, 4, 6, 1]
Output: 2

Input: [6, 12, 18]
Output: 0
```

> Problem 4. (Purpose: Single while loop)

```
// 4 
public static float [] positiveAverage(int [] arr1)
```

Given one integer array. Write a method that calculates:
- The number of positive integers in a given array
- The average of these positive integers.

Returns both numbers in an array, where the first element is the number of positive integers, and the second element is their average.

**Notes:**
1. Round the average answer to 2 decimals. 
2. Use `Math.round()` for rounding. However, this method only returns an integer! Try to figure out a way around.
3. Try to use a while loop for practice to solve this problem.

**Example**:

```
Input: [1, 3, 4] 
Output: 3.0
      2.67
  
Input: [4, 4, -6, 1]
Output: 3.0
       3.0

Input: []
Output: 0.0
      0.0

Input: [-4, -4, -6, -1]
Output: 0.0
      0.0
```

> Problem 5. (Purpose: Combining a while loop and Boolean logic)

```
// 5
public static boolean sameDigitFirstAndLast(int num1, int num2)
```

Write a method that takes two non-negative integers and returns `true` if the first digit of the first number is the same as the last digit of the second number. 

**Example:**

```
Input: 57, 78 
Output: false  

Input: 7333, 7
Output: true
```

> Problem 6. (Purpose: Combining a for loop and Boolean logic)

```
// 6 
public static boolean decreasingOrder(int[] elems)
```

Write a method that takes in an integer array and returns `true` if there are **three** consecutive decreasing numbers in this array.

**Example:**

```
Input: [1, 2, 3, 6, 5, 4]
Output: true
Explanation: 6, 5, 4 are decreasing. 

Input: [5, 6, 7, 10, 6, 3]
Output: true
Explanation: 10, 6, 3 are decreasing. 

Input: [10, 8, 22, 21, 30, 29] 
Output: false 

Input: [6, 3, 5, 2, 4, 1]
Output: false
Explanation: numbers are not in consecutive order
```

> Problem 7. (Purpose: Manipulating a 2-D Array)

```
// 7 
public static void replaceMainDiagonal(int[][] elems)
```

Write a method that takes a 2D integer array (square matrix) and replaces its main diagonal with its sum by mutating the input. 

> Problem 8. (Purpose: Loop and Array)

```
// 8
public static float averageGrade(int[][] grades, int assignmentIndex)
```

Write a method that takes in a 2-D array where each row represents a student and each column represents an assignment, and the index for an assignment. It returns the average grade for an assignment at the given index. 

**Notes:**
1. Round the answer to 3 decimals. 
2. Use `Math.round()` for rounding. However, this method only returns an integer! Try to figure out a way around.
3. Assume the assignmentIndex will be valid.


**Example:**

```
Input: [[1, 3, 2, 2], [2, 3, 4, 3], [9, 9, 10, 10]], 0
Output: 4.0
Explanation: (1+2+9)/3 = 4.0
	
Input: [[1, 10, 3, 2, 7], [10, 4, 3, 4, 3], [6, 3, 9, 1, 3]], 1
Output: 5.667
Explanation: (10+4+3)/3 = 5.667
```


> Problem 9. (Purpose: Recursion and String Operations)

```
// 9
public static String noDots(String str)
```

Write a method that takes in a string and returns a new string where all the dots ('.') have been removed.

**Notes:**
1. This method should be done by **recursion**. (There is a one line solution that uses the `replace` method, you are NOT allowed to use it).
2. Built-in methods `charAt` and `substring` can be useful here. 

**Example:**

```
Input: "Recursion is cool." 
Output: "Recursion is cool"

Input: "M.A.R.I.N.A"
Output: "MARINA"

Input: "no dots!"
Output: "no dots!"
```

> Problem 10. (Purpose: Conditionals and Arrays)

```
// 10
public static int[] twoElements(int[] elems)
```

Write a method that takes in an array of integers and returns a new array of length 2 containing two elements:
- If the original array's length is less than two, return an empty array. 
- If the original array's length is even, return the middle two elements from the original array 
0 If the original array's length is odd, return the first and the last elements as the output array. 

**Requirement:**
- Your function should not modify the original array. 

**Example:**

```
Input: [2, 2, 3, 3, 4, 4, 5, 5] 
Output: [3, 4]  

Input: [3] 
Output: [] 

Input: [1, 14, 3] 
Output: [1, 3] 
```

## Part 3 Extra Credit (+10 Points)

### One Hot Encoding

Analyzing numeric data is often straightforward. Suppose you have a list of ages of students in DSC30. Each age will be indicated as a number, and you can easily calculate the average, visualize the distribution, etc. 

However not all data is numeric. Data has several other distinct types, such as categorical data. Examples of categorical data are nationality, which residential colleges you are in, etc. Unlike numeric data, categorical data is more complicated to analyze because they cannot be directly interpreted mathematically. For example, which number should Revelle College and Sixth College map to? If we assign 1 to Revelle and 2 to Sixth, does it mean Sixth is worth more than Revelle? Probably not.

A common solution to this challenge is called **One Hot Encoding.** It transforms a categorical feature into a one-hot matrix where we use one array for each unique value in the feature, and use 1 to represent the occurrence of this value. For more context and information, please [refer to this website](https://www.educative.io/blog/one-hot-encoding). Below is a brief example of how this works.

![img](https://miro.medium.com/v2/resize:fit:720/format:webp/1*O_pTwOZZLYZabRjw3Ga21A.png)

**Explanation:**
- There are 4 unique pets (Ca, Dog, Turtle, Fish): it gives you the first dimension of the matrix. 
- There are 5 pets in total: it gives you the second dimension of the matrix. 
- Now, for each occurrence of a pet, you put 1, otherwise you put a 0. 

We will break the solution into three methods in order to understand the process better.

> Part 1.  getUnique()

For a given string array that contains several categorical values, return the array with the unique categories but with the same length. The sequence of the returned unique element array is corresponding to the sequence of the first occurrence of each value. 

```
// EC.1
public static String[] getUnique(String[] arr)
```

**Example:**

```
Input : ["BMW", "BMW", "Toyota", "Toyota", "BMW", "Honda", "BMW"]
Output: ["BMW", "Toyota", "Honda", null, null, null, null]
```

**Notes:**
- Output array has the same length as the input array (what if every element is unique?)
- Keep the order of the unique elements the same as in the original list (i.e. Honda can’t appear before BMW)
- Make sure to test your code with more inputs! No hardcoding! 

> Part 2: getNumOfUniqueElements()

Once you have your array with unique elements calculated, we can use it to find out the number of unique elements. Write a function that takes a string array and outputs a number of unique elements. 

```
// EC.2
private static int getNumOfUniqueElements(String[] arr)
```

**Example:**

```
Input: ["BMW", "Toyota", "Honda", null, null, null, null]
Output: 3
```

For a given unique values array, return the number of non-null elements in the array. This is a helper method for the `oneHotEncode()` method with the result from `getUnique()` so that we understand how many unique elements are present in the input array.

> Part 3. oneHotEncode()

Now we are reading to produce the one-hot-encoding matrix. Write a function that takes a string array (categorical feature array) and outputs a feature matrix using one-hot-encoding. You should use methods from part 1 and part 2 to implement this function. 

```
// EC.3
public static int[][] oneHotEncode(String[] arr)
```

**Example:**

```
Input : ["BMW", "BMW", "Toyota", "Toyota", "BMW", "Honda", "BMW"]

uniqueArray: ["BMW", "Toyota", "Honda", null, null, null, null]

Output: [[1, 1, 0, 0, 1, 0, 1],
         [0, 0, 1, 1, 0, 0, 0],
         [0, 0, 0, 0, 0, 1, 0]]
```

A brief explanation of the output:

```
Output: [[1, 1, 0, 0, 1, 0, 1],  ->  (BMW)
         [0, 0, 1, 1, 0, 0, 0],  ->  (Toyota)
         [0, 0, 0, 0, 0, 1, 0]]  ->  (Honda)
```

The output sequence of the one-hot-encoded array should have the same sequence with the unique array you generated on.

Congratulations! After you implement those one-hot-encoded arrays, now you can feed the matrix into one of the machine learning pipelines of your own! 

## Submission

Files to Submit
- HelloWorld.java
- ProgrammingChallenges.java
- OneHot.java (Extra Credit, Optional)

Instructions for Submission

![image](https://user-images.githubusercontent.com/50224596/231064671-3d79706b-29da-44ea-a238-b80dd9760757.png)

Once you finish your assignment, you should commit and push your code to Github first.

Then log into Gradescope, and select our course DSC30. On the class dashboard, select the current assignment PA1. 

Upon clicking the assignment, a window will prompt for the submission method to select. Select **GitHub** as your submission method. (Note that we only keep the Upload submission method in the first PA in case you have problems using Github. **Starting from next PA, we will disable the upload method and leave only Github as the submission method**) Then click **Connect to GitHub**. Now log in to your Github account and click **Authorize gradescope**.

![image](https://user-images.githubusercontent.com/50224596/231064731-88ee3f59-f8d9-4955-a1ac-0ef27d5a3f54.png)

Select your private repository **dsc30-pa1** as the REPOSITORY, and **main** as the BRANCH. Then click Upload.

A notification window will display once your files have been submitted.

***IMPORTANT***: Please ensure that you see the following successful submission message under Autograder Results. If you see any other output, your submission is NOT successful. Check the submission error messages in the next section. If you need assistance or see anything unusual, please ask one of the staff or post on Piazza. 
- Common mistake: Make sure that ProgrammingChallenges.java is located within the src folder. 

![image](https://user-images.githubusercontent.com/50224596/231064811-963591a0-ba98-4fcc-abf8-897bd405e49c.png)

### Submission Error Messages
In a partial or incomplete submission you may receive the following error messages:
- SUBMISSION FAILED. THE FOLLOWING FILES DO NOT EXIST

    If you see this, make sure that you have submitted all of your .java files required for this assignment. 

- SUBMISSION FAILED. FILES DO NOT COMPILE.

    Seeing this message means that there are compilation errors in your code. Check the error output and debug these errors before continuing.

- SUBMISSION FAILED. FILES DO NOT COMPILE WITH TESTING CODE.

    At least one of your method signatures is not consistent with the write-up. The error output will specify the lines corresponding to incorrect method signature.

Let us know if you see any other error messages.
