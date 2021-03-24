(ns app.core
  "This namespace contains your application and is the entrypoint for 'yarn start'."
  (:require [app.navigation.routes :refer [routes]]
            [app.navigation.nav :refer [nav]]
            ; SUBSCRIPTIONS & EVENTS
            [app.state.db]
            [app.state.effects.navigation.events]
            [app.state.effects.navigation.subs]
            [app.state.effects.transactions.subs]
            [app.state.effects.transactions.events]
            [app.state.effects.auth.events]
            [app.state.effects.auth.subs]
            [app.state.effects.profile.events]
            ; THIRD PARTY LIBS
            [re-frame.core :as rf]
            [reagent.core :as r]
            [stylefy.core :as stylefy]))

(defn- app
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
  (stylefy/init)
  (start))
