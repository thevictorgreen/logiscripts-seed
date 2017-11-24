// Jenkins Job DSL to create Jobs

//Base Path For All Jobs Related to this project
def basePath = 'LogiscriptsProject';

//Folder already exists. Seed job inside of it
folder (basePath) {
  displayName('LogiscriptsProject');
  description('Folder for LogiscriptsProject');
}


//Git repository for logiscripts-userportal
def repoUrl = "https://github.com/thevictorgreen/logiscripts-userportal.git"; //Repository UrL

pipelineJob(basePath + "/logiscripts-userportal") { //JobName
  description("Application frontend for the Logiscripts user portal");
  definition {
    cpsScm {
      scriptPath("Jenkinsfile"); //Path to Build Script
      scm {
        git {
          remote {
            url(repoUrl); //Git Repository
            branch("master");
          }
        }
      }
      triggers {
        githubPush();
      }
    }
  }
}


