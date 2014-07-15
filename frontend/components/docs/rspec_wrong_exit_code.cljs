(ns frontend.components.docs.rspec-wrong-exit-code)

(def article
  {:title "RSpec is failing but CircleCI reports my tests have passed"
   :last-updated "Dec 20, 2013"
   :url :rspec-wrong-exit-code
   :content [:div
             [:p
              "CircleCI uses the exit code of each test command to determine success orfailure. A combination of bugs in Ruby and RSpec can make RSpec return anexit code of 0 (indicating success) even when the specs have failed, trickingus into reporting success incorrectly."]
             [:h2 "The gory details"]
             [:p
              "RSpec runs in an "
              [:code "at_exit"]
              " block. This makes it easy to run witheither "
              [:code "ruby"]
              " or "
              [:code "rspec"]
              "."]
             [:p
              "But this also makes RSpec susceptible to some bugs and/or incorrect"
              [:code "at_exit"]
              " blocks resetting its exit code.The major causes are:"]
             [:ol
              [:li
               [:a
                {:href "http://bugs.ruby-lang.org/issues/5218"}
                "A bug in Ruby's at_exit code"]
               "where exceptions thrown during at_exit cause the exit status to be resetto 0, even if the exception is handled inside the "
               [:code "at_exit"]
               "block. This bug has been difficult to truly squash and has appeared in"
               [:a
                {:href "https://gist.github.com/gordonsyme/8062293"}
                "several Ruby versions"]
               "over time."]
              [:li
               [:a
                {:href "https://github.com/rspec/rspec-core/pull/569"}
                "A bug in RSpec's at_exit block"]
               "which masks non-zero exit codes by ignoring the value of "
               [:code "$!"]
               "."]
              [:li
               [:code "at_exit"]
               " blocks added by the code under test which don'tpropagate the exit status properly."]]
             [:h2 "How to fix"]
             [:p
              "You should be able to reproduce the problem either locally or via SSH into abuild machine:"
              [:code "bundle exec rspec some-failing-test"]
              " followed by "
              [:code "echo$?"]
              " to show the exit code."]
             [:p
              "The first thing to do is to upgrade your Ruby patchset and/or your RSpecversion to make sure you have the fixes for the above bugs."]
             [:p
              "After that, with RSpec, the most common source of incorrect exit statuses is"
              [:code "at_exit"]
              " blocks which either call "
              [:code "exit"]
              " and fail topropagate the previous exit status, or throw exceptions. Do you have any"
              [:code "at_exit"]
              " code that might be breaking?"]
             [:p
              "You can use this pattern to preserve non-zero exit codes if you do need tocall "
              [:code "exit"]
              " from your "
              [:code "at_exit"]
              " blocks:"]
             [:pre
              "’‘"
              [:code.ruby
               "’at_exit do  new_exit_status = cleanup_code arg1, arg2  exit new_exit_status unless $!end‘"]
              "’‘"]]})

