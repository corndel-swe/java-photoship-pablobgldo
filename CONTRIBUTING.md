# Contributing

Before contributing, please make sure you've completed the deep dive exercises.

## Workshop

With the deep dive completed, you're ready to work on Photoship! This is quite a
mature project, but we need your help to finish it off.

In `src/main/java/com/corndel/photoship/lib/Pixels.java` you will find plenty of
functions whose job it is to manipulate individual pixels of an image, by
messing around with the RGB (red, green, blue) values of the pixel.

## Using the app

If you have successfully run `./mvnw clean compile`, you should be able to
process an image already. Notice that `cat.jpg` is in the
`src/main/resources/img` folder. Let's remove all the red from the image.

Open a terminal in the root of the project and run

```bash
./mvnw exec:java -Dexec.args="strip-red cat.jpg"
```

Now check out `src/main/resources/imgoutput.jpg` - if all goes well you should
see a very blue and green cat.

## Completing the app

If you type

```bash
./mvnw exec:java -Dexec.args="--help"

```

you can see all the functionality the app is supposed to provide. But only
`strip-red` is working! That's where you come in.

Complete the functions in `Pixels.java` to get the app working. Make sure to
check each one works

E.g. when you complete the `stripBlue` function, try

```bash
./mvnw exec:java -Dexec.args="strip-blue cat.jpg"
```

and check `img/output.jpg` again.

Your job is to use what you've learned to complete these functions. See
`TODO.md` for a todo list to track your progress.
