(ns cocoapods-acknowledgements-licenses.core
  "Parse Apple Plist file with CocoaPods dependencies into clojure native map"
  (:gen-class)
  (:require
   ;;[clojure.spec.test.alpha :refer [instrument]]
   [clojure.spec.alpha :as s]
   [com.github.bdesham.clj-plist :refer [parse-plist]]))

;; Specs

(s/def ::nilable-str (s/nilable string?))

(s/def ::package ::nilable-str)
(s/def ::license ::nilable-str)
(s/def ::path string?)
(s/def ::options (s/map-of keyword? any?))
(s/def ::plist-item (s/map-of string? any?))

(s/def ::data
  (s/cat :package ::package :license ::license))

(s/def ::package-data
  (s/nilable (s/coll-of ::version)))

;; Const

(def key-specifiers "PreferenceSpecifiers")
(def key-package-name "Title")
(def key-license-name "License")

;; Helpers

(s/fdef plist-item->map
  :args ::plist-item
  :ret ::data)

(defn- plist-item->map
  "Convert plist item map to proper format"
  [item]
  (let [package (get item key-package-name)
        license (get item key-license-name)]
    {:package package :license license}))

;; Entrypoint

(s/fdef plist->data
  :args (s/cat
         :path ::path
         :options ::options)
  :ret ::data)

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

;; (instrument `plist->data)
