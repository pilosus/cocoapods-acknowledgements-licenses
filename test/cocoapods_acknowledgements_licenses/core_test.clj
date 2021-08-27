(ns cocoapods-acknowledgements-licenses.core-test
  (:require [clojure.test :refer [deftest is testing]]
            [cocoapods-acknowledgements-licenses.core :as core]))

(def default-path "resources/deps.plist")

(def default-plist-data
  [{:package "Acknowledgements" :license nil}
   {:package "FBSDKCoreKit" :license "Facebook Platform License"}
   {:package "FirebaseAnalytics" :license "Copyright"}
   {:package "Swinject" :license "MIT"}
   {:package "lottie-ios" :license "Apache"}
   {:package "nanopb" :license "zlib"}
   {:package nil :license nil}])

(def params-plist->data-integration
  [[{} (butlast (rest default-plist-data)) "No options provided, use defaults"]
   [{:skip-header true :skip-footer true} (butlast (rest default-plist-data)) "Skip header explicitly, skip footer explicitly"]
   [{:skip-header false :skip-footer true} (butlast default-plist-data) "Keep header explicitly, skip footer explicitly"]
   [{:skip-header true :skip-footer false} (rest default-plist-data) "Skip header explicitly, keep footer explicitly"]
   [{:skip-footer false} (rest default-plist-data) "Skip header implicitly, keep footer explicitly"]
   [{:skip-header false} (butlast default-plist-data) "Keep header explicitly, skip footer explicitly"]
   [{:skip-header false :skip-footer false} default-plist-data "Keep header explicitly, keep footer explicitly"]])

(deftest test-plist->data-integration
  (testing "Test convertng plist file into clojure map"
    (doseq [[options expected description] params-plist->data-integration]
      (testing description
        (is (= expected (core/plist->data default-path options)))))))
