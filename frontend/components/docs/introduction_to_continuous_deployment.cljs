(ns frontend.components.docs.introduction-to-continuous-deployment)

(def article
  {:title "Introduction to Continuous Deployment"
   :last-updated "March 12, 2014"
   :url :introduction-to-continuous-deployment
   :content [:div
             [:p
              "Circle enables you to automatically deploy after green builds.We have customers deploying to PaaSes such as Heroku, Engine Yard,and Google App Engine, hosted cloud servers (like EC2 and Rackspace),and to private and colo servers—even behind firewalls.Some use tools like Capistrano, Fabric, and Paver."]
             [:p
              "However you want to deploy your code, Circle makesContinuous Deployment easy."]
             [:h3 "Deployment syntax"]
             [:p
              "Tell Circle about your deployment requirements in the "
              [:code "deployment"]
              "section of your"
              [:a {:href "/docs/configuration"} "circle.yml"]
              "file.Within this section, you can can define custom deployment steps for eachbranch, directing Circle to use specific deployment tools or custom scripts.Deployment commands are triggered only after a successful build."]
             [:p
              "The following example will run the"
              [:code "deploy-to-production.sh"]
              "script when the tests pass on the master branch and run the"
              [:code "deploy-to-staging.sh"]
              "script when the tests pass on the staging branch."]
             [:pre
              "’‘"
              [:code.no-highlight
               "’deployment:  production: # just a label; label names are completely up to you    branch: master    commands:      - ./deploy-to-production.sh  staging:    branch: staging    commands:      - ./deploy-to-staging.sh‘"]
              "’‘"]
             [:h3 "Deploy over SSH"]
             [:p
              "First you need to upload your SSH keys from your project's"
              [:b "Edit settings > SSH keys"]
              " page in the Circle UI.Circle will automatically add them to the "
              [:code "ssh-agent"]
              ",so they are available for forwarding."]
             [:p
              "You can list commands or include bash scripts for SSH deployment in the"
              [:code "circle.yml"]
              " file.You can also use tools such as Capistrano or Fabric when deploying toprivate servers or to EC2, Rackspace, and other cloud hosting providers."]
             [:p "You can use your existing Capistrano recipes, for example:"]
             [:pre
              "’‘"
              [:code.no-highlight
               "’deployment:  production:    branch: master    commands:      - bundle exec cap production deploy‘"]
              "’‘"]
             [:p "Here's an example using Fabric:"]
             [:pre
              "’‘"
              [:code.no-highlight
               "’deployment:  production:    branch: master    commands:      - fab deploy‘"]
              "’‘"]
             [:h3 "Deploy to a PaaS"]
             [:p
              "Circle has customers deploying to Heroku, Engine Yard, Google App Engine, Elastic Beanstalk, Dot Cloud, Nodejistu and other PaaSes. We have detailed instructions on"
              [:a
               {:href "/docs/continuous-deployment-with-heroku"}
               "deployment to Heroku"]
              "and "
              [:a
               {:href "/docs/deploy-google-app-engine"}
               "deployment to Google App Engine"]
              ".If you'd like help setting up your deployment, please"]
             [:h3 "Firewalls, webhooks, and Circle's Public IP address ranges"]
             " + $c(this.include_article('ec2ip_and_security_group'))"
             [:p
              "Use the IP address ranges and security group number as needed to configurea physical or in-the-cloud server under your control.If you run into any problems, + $c(HAML['contact_us']())and we'll be happy to help."]]})

