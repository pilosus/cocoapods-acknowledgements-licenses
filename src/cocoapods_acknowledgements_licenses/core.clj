(ns cocoapods-acknowledgements-licenses.core
  "Parse Apple Plist file with CocoaPods dependencies into clojure native map"
  (:gen-class)
  (:require
   [com.github.bdesham.clj-plist :refer [parse-plist]]))

(def key-specifiers "PreferenceSpecifiers")
(def key-package-name "Title")
(def key-license-name "License")

(defn- plist-item->map
  "Convert plist item map to proper format"
  [item]
  (let [package (get item key-package-name)
        license (get item key-license-name)]
    {:package package :license license}))

(defn plist->data
  "Parse Plist into vector of {:package PACKAGE :license LICENSE} maps"
  [path options]
  (let [{:keys [skip-header skip-footer] :or {skip-header true skip-footer true}} options
        parsed-plist (parse-plist path)
        deps (get parsed-plist key-specifiers)
        formatted (map plist-item->map deps)
        formatted' (if skip-header (rest formatted) formatted)
        formatted'' (if skip-footer (butlast formatted') formatted')]
    formatted''))
