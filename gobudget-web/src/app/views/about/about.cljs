(ns app.views.about.about)

(defn about []
  [:div {:style {:width "100%"
                 :padding "30px 0"
                 :display "flex"
                 :align-items "center"
                 :justify-content "center"}}
   [:div {:style {:display "flex"
                  :flex-direction "column"}}
    [:div
     [:img {:src "assets/logo.svg"
            :alt "GoBudget logo"
            :style {:width "300px"}}]]
    [:div
     [:p {:style {:color "#969cb3"
                  :width "580px"}}
      "Take your money management to the next level."]]]
   [:div {:style {:color "#363F5F"}}
    [:p "Hi, there! I'm glad you are here. My name is Alexandre and I am a 
        software engineer who has fallen in love with Clojure(Script)."]
    [:br]
    [:p "This project is still a work in progress, and it is subject to change 
         in the future regarding source code, project structure, UX/UI and so 
         on. It is my attempt to learn this beautiful language, as well the 
         frameworks and tooling that revolves around it. "]
    [:br]
    [:p "Right now it is a simple SPA with very few functionalities, but my idea
         is to englobe both backend and frontend (maybe even mobile + 
         Clojurescript) as I progress in my learnings. You can follow my 
         adventures through my "
     [:a {:href "https://medium.com/codex/creating-a-clojurescript-spa-for-the-first-time-pt-1-d3012c42e622"}
      "series of medium articles."]
     " Also, feel free to check the source code for the project in its "
     [:a {:href "https://github.com/alesevero/gobudget"} "Github repo."]]
    [:br]
    [:p "Cheers!"]
    [:p "Alexandre"]]])