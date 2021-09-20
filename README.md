# Road to Chef

Road to Chef aspires to be an inclusive experience for all high school students who share a passion for cooking. It offers them a community to share their passion.

## Table of Contents
* [How To Run](#how-to-run)
* [The Issue](#the-issue)
* [Our Magic Solution](#our-magic-solution)
* [How It Works](#how-it-works)
* [Recommendations for Implementation](#recommendations-for-implementation)
* [Next Steps — Future Features and Recommendations](#next-steps--future-features-and-recommendations)

## How To Run
Download the latest version of **Android Studio** and open this root file of this project in the IDE. From there, you can open the emulator in the IDE and run the solution. This app was tested with the Google Pixel 2 emulator set on Android 11. We highly recommend you use the same settings for the optimal experience.

## The Issue

La Tablée des Chefs (LTDC) expressed the need for a digital solution in order to reach more high school students with their culinary activities. LTDC wanted a solution to create a sense of community amongst its users whilst promoting healthy eating habits and ecological ones.

## Our Magic Solution

Our Android application is unique in the sense that it doesn't only offer independent features, it offers tightly knit features that create an inclusive experience for the user. Any high school student who would register with our application would automatically connect with all the users attending the same school, thus creating a community around a shared passion, cooking.

## How It Works

### Create an Account

Create an account and connect automatically with all your peers.

### See what your friends are doing

Log in to the main feed of the application and start sharing, reacting and commenting on your peers content.

### Challenge your friends, challenge your school

Create open challenges for all to take on or challenge your best friend to a hard recipe with extra constraints.

### See how well others are doing

Track the leaderboard to see how you rank compared to your peers. Who's sharing the most content? Who's completing the most challenges?

### Share your posts on social media

See something on the feed you really like? Share it on other social media! (*Facebook currently suported)

## Recommendations for Implementation

### When confirming a challenge, send a picture of the meal to confirm it is done

Whereas we only implemented part of the solution, sending a notification that the challenge is accepted to the user, this can be used to instead prompt the user to submit a photo. Without having any database, this would not have gone much further than this, but in the full version, there definitely should be this functionality. Plus, posting an unprompted challenge on the feed should be something to implement as well.

### Store recipes, profiles, challenges and schools on a database

While we couldn't implement a server with the little time we had to code our app, with how we structured the code, it would be easy to use either an external food API like Spoontaculer to do the recipes, or host a list yourself on a database. There should be "base" challenges, created by La Tablée des Chefs, and "community" challenges, created by each user and approved by a moderator at school.

### Use the existing ChefRisingStar app to create recipes and additional challenges

The existing ChefRisingStar app did something very interesting: you could substitute some foods for others, most notably for the ecological impact, and for a vegan-friendly option. That is a great thing, and we would recommend to use this to your advantage when giving the user the control to create new challenges.

## Next Steps — Future Features and Recommendations

* Instant messaging system
* Boons for redeeming points (in-app profile customization, for example)
* Achievements
* In-person QR code scanning to earn bonuses
* Give points through the Défi Attache Ta Toque and other events organized by LTDC
* Implement the streak counter and the friends list we made space for on the toolbar. Give points for connecting many days in a row
