# sfdc-heroku-remotetasks

A training Scala app (using the Play framework) for Salesforce Academy, which can easily be deployed to Heroku, in order to test calling external service via REST from Apex.

This application support the [Getting Started with Scala/Play on Heroku](https://devcenter.heroku.com/articles/getting-started-with-scala) article - check it out.

## Running Locally

Make sure you have Play and sbt installed.  Also, install the [Heroku Toolbelt](https://toolbelt.heroku.com/).

```sh
$ git clone https://github.com/wojdyga/sfdc-heroku-remotetasks.git
$ cd sfdc-heroku-remotetasks
$ sbt compile stage
$ heroku local
```

Your app should now be running on [localhost:5000](http://localhost:5000/).

## Deploying to Heroku

```sh
$ heroku create
$ git push heroku master
$ heroku open
```

## Documentation

For more information about using Play and Scala on Heroku, see these Dev Center articles:

- [Play and Scala on Heroku](https://devcenter.heroku.com/categories/language-support#scala-and-play)

