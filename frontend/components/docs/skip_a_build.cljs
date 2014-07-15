(ns frontend.components.docs.skip-a-build)

(def article
  {:title "Skip a build"
   :last-updated "Feb 2, 2013"
   :url :skip-a-build
   :content [:div
             [:p
              "CircleCI supports the "
              [:code "[ci skip]"]
              " standard for ignoring builds."]
             [:p
              "CircleCI won't run the build if we find "
              [:code "[ci skip]"]
              " anywhere in the commit message of the head commit. You can use the handy retry button on the build page if you decide that you want to run the build after all."]
             [:h2 "Example"]
             [:p
              "If Daniel pushes his last two commits now, CircleCI won't run tests for that push:"]
             "‘"
             [:pre
              {:style "padding: 10px;"}
              "’$ git log origin/master..HEADcommit 63ce74221ff899955dd6258020d6cb9accede893Author: Daniel Woelfel <daniel@circleci.com>Date:   Wed Jan 23 16:48:25 2013 -0800    fix misspelling [ci skip]commit 463147193b2fe561cfb12a9787434dd726390fcdAuthor: Daniel Woelfel <daniel@circleci.com>Date:   Wed Jan 23 16:30:24 2013 -0800    add \\Skip a build\\ doc‘"]
             "’"
             [:p
              "Note that if the commits were in the opposite order, then the push would have been built."]]})
