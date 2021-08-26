(defproject org.clojars.vrs/cocoapods-acknowledgements-licenses "0.1.0-SNAPSHOT"
  :description "CocoaPods Acknowledgements Plist file parser"
  :url "https://github.com/pilosus/cocoapods-acknowledgements-licenses"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [com.github.bdesham/clj-plist "0.10.0"]]
  :plugins [[lein-cljfmt "0.7.0"]
            [lein-cloverage "1.2.1"]]
  :repl-options {:init-ns cocoapods-acknowledgements-licenses.core}
  :repositories [["releases" {:url "https://repo.clojars.org"
                              :sign-releases false
                              :username :env/clojars_username
                              :password :env/clojars_password}]])
