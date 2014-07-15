(ns frontend.components.docs.browser-debugging)

(def article
  {:title "Interacting with the browser on CircleCI's VM"
   :last-updated "May 30, 2014"
   :url :browser-debugging
   :tags ["browser", "capybara", "webkit", "chrome", "firefox", "selenium", "X11", "xorg"]
   :content [:div
             [:p
              "Integration tests can be hard to debug, especially when they're running on a remote machine.There are two good ways to debug browser tests on CircleCI."]
             [:h2 "Screenshots and artifacts"]
             [:p
              "At the end of a build on CircleCI,we will gather up all"
              [:a {:href "/docs/build-artifacts"} "build artifacts"]
              "and make them available from your build.This allows you to save screenshots as part of your build,and then view them when the build finishes."]
             [:p
              "Saving screenshots is straightforward:it's a built-in feature in webkit and selenium, and supported by most test suites:"]
             [:ul
              [:li
               [:a
                {:href
                 "http://docs.seleniumhq.org/docs/04_webdriver_advanced.jsp#remotewebdriver"}
                "Manually, using Selenium directly"]]
              [:li
               [:a
                {:href "https://github.com/mattheworiordan/capybara-screenshot"}
                "Automaticaly on failure, using Cucumber"]]
              [:li
               [:a
                {:href "https://gist.github.com/michalochman/3175175"}
                "Automaticaly on failure, using Behat and Mink"]]]
             [:p
              "To make this work with build artifacts, you need to save the screenshot to the"
              [:code "$CIRCLE_ARTIFACTS"]
              "directory."]
             [:h2 "X11 forwarding over SSH"]
             [:p
              "CircleCI supports X11 forwarding over SSH to make this process much easier. X11 forwarding is similar to a remote desktop -- you can interact with the browser running on CircleCI from your local machine."]
             [:p
              "Before you start, make sure you have an X Window System on your computer. If you're using OSX, I recommend"]
             [:p
              "With X set up on your system,"
              [:a {:href "/docs/ssh-build"} "start an SSH build"]
              "to a CircleCI VM, using the"
              [:code "-X"]
              "flag to set up forwarding:"]
             [:pre
              "’‘"
              [:code.bash "’daniel@mymac$ ssh -X -p PORT ubuntu@IP_ADDRESS‘"]
              "’‘"]
             [:p
              "This will start an SSH session with X11 forwarding enabled.To connect your VM's display to your machine, set the display environment variable to localhost:10.0"]
             [:pre
              "’‘"
              [:code.bash "’ubuntu@box10$ export DISPLAY=localhost:10.0‘"]
              "’‘"]
             [:p "Check that everything is working by starting xclock."]
             [:pre "’‘" [:code.bash "’ubuntu@box10$ xclock‘"] "’‘"]
             [:p
              "You can kill xclock with Ctrl+c after it appears on your desktop."]
             [:p
              "Now you can run your integration tests from the command line and watch the browser for unexpected behavior. You can even interact with the browser — it's as if the tests were running on your local machine!"]]})
