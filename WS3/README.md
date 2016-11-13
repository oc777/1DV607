
#Work Shop 3

Olga Christensen (oc222ba)

##Grade 2

1. Source code [here] (https://github.com/oc777/1DV607/tree/master/WS3/BlackJack)


##Grade 3

1. Source code [here] (https://github.com/oc777/1DV607/tree/master/WS3/Grade3/BlackJack)

2. Runnable jar [here] (https://github.com/oc777/1DV607/tree/master/WS3/Grade3)


##Grade 4

1. Source code [here] (https://github.com/oc777/1DV607/tree/master/WS3/Grade4/BlackJack)

2. Runnable jars [here] (https://github.com/oc777/1DV607/tree/master/WS3/Grade4)

__N.B.__ There are two runnable versions  
- one for console (run with `java -jar BlackJack-Grade4-Console.jar`)  
- another with GUI (double-click on the file to run)


***


###Report

When working on implementing a GUI for Grade 4, I encountered further issues:

1. I had to find out how to display text that `console` printed with `System.out.print()`. I didn't want to change a lot of the existing code, so I did a simple fix, which is probably not the most good-looking one, but it works.

2. I have created `buttons` for user to pass the decision to the `controller` but they created an infinite loop while waiting for some `events` to happen, so the app ran out of memory. 

3. After some manipulations to solve the previous issue, I got into another problem - the `while (ctrl.Play())` didn't loop anymore, hence the game "hanged" after the initial dealing of cards. I couldn't find a solution that would keep the `view-controller` separation intact. So I let `view` and `controller` to "communicate" to keep the app running. 

4. I have tried multiple variations of pausing the game when a card is dealt, but it didn't work for GUI version - there is no pause between dealing the cads :(





