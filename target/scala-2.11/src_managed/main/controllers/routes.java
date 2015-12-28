// @SOURCE:/home/alek/Git/sfdc-heroku-remotetasks/sfdc-heroku-remotetasks/conf/routes
// @HASH:3b54f8c4458c885e71afe5ad2d83390ebdfebeb7
// @DATE:Tue Dec 15 22:24:50 CET 2015

package controllers;

public class routes {
public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets();
public static final controllers.ReverseApplication Application = new controllers.ReverseApplication();

public static class javascript {
public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets();
public static final controllers.javascript.ReverseApplication Application = new controllers.javascript.ReverseApplication();
}
          

public static class ref {
public static final controllers.ref.ReverseAssets Assets = new controllers.ref.ReverseAssets();
public static final controllers.ref.ReverseApplication Application = new controllers.ref.ReverseApplication();
}
          
}
          