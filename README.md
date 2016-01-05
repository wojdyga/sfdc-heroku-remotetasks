# sfdc-heroku-remotetasks

A training Scala app (using the Play framework) for Salesforce Academy. Deploy this project to Heroku and call this external service via REST from your Apex code.

## Running Locally

Make sure you have Play, sbt and Postgresql installed.  Also, install the [Heroku Toolbelt](https://toolbelt.heroku.com/).

```sh
$ git clone https://github.com/wojdyga/sfdc-heroku-remotetasks.git
$ cd sfdc-heroku-remotetasks
$ sbt compile stage
$ export DATABASE_URL=jdbc:postgresql:///$(whoami)
$ heroku local
```

Your app should now be running on [localhost:5000](http://localhost:5000/).

## Deploying to Heroku

Deploying this app to Heroku run Postgresql by default.

```sh
$ heroku create
$ git push heroku master
$ heroku open
```

## Documentation

For more information see these Dev Center articles:

- [Getting Started with Scala and Play on Heroku](https://devcenter.heroku.com/articles/getting-started-with-scala#introduction)
- [Play and Scala on Heroku](https://devcenter.heroku.com/categories/language-support#scala-and-play)
- [Heroku Postgresql](https://devcenter.heroku.com/articles/heroku-postgresql)
