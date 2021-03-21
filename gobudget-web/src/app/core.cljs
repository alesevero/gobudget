(ns app.core
  "This namespace contains your application and is the entrypoint for 'yarn start'."
  (:require [app.routes :refer [routes]]
            [app.nav.views.nav :refer [nav]]
            ; SUBSCRIPTIONS & EVENTS
            [app.db]
            [app.nav.events]
            [app.nav.subs]
            [app.transactions.subs]
            [app.transactions.events]
            [app.auth.events]
            [app.auth.subs]
            ; THIRD PARTY LIBS
            [re-frame.core :as rf]
            [reagent.core :as r]))

(defn app
  []
  (let [active-page @(rf/subscribe [:active-nav])]
    [:div {:style {:width "100%"
                   :max-width "1120px"
                   :margin "0 auto"
                   :padding "40px 20px"}}
     [nav]
     [routes active-page]]))

(defn ^:dev/after-load start
  []
  (r/render [app]
            (.getElementById js/document "app")))

(defn ^:export init
  []
  (rf/dispatch-sync [:initialize-db])
  (start))
