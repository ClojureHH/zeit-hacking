(defproject zeit-hacking "0.1.0-SNAPSHOT"
  :description "A little hack-project for the Hamburg Clojure Meetup"
  :url "https://github.com/chrisbetz/zeit-hacking"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [http-kit "2.1.18"]
                 [cheshire "5.5.0"]
                 [gorillalabs/config "1.0.1"]
                 [gorilla-renderable "2.0.0"]]
  :plugins [[lein-gorilla "0.3.4"]]
  )
