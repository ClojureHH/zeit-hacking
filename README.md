# zeit-hacking

A little hack-project for the Hamburg Clojure Meetup to play arount with
[GorillaREPL](http://gorilla-repl.org/index.html), the [Zeit API](http://developer.zeit.de/index/), and other stuff.
## Usage

Add your own API-Key in a ```resources/api-key.edn``` like this:

    ;; In file 'resources/api-key.edn'
    {:api-key "..."}

Then run

    lein gorilla :port 8999

and point your browser to

[http://127.0.0.1:8999/worksheet.html?filename=ws/zeit-hacking-worksheet.clj](http://127.0.0.1:8999/worksheet.html?filename=ws/zeit-hacking-worksheet.clj)


## License

Copyright © 2015 Dr. Christian Betz

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
