# headlines-challenge

The api key is currently stored directly in the gradle file (nb. i didn't commit the api key), but it needs to be manually pasted in as a buildconfig value to work.

I would have set up a local file for keys if i had the time.

The app is very barebones, and only displays the first page of results in a simple listview.

The main feature it has is extensibility due to the fact that dagger is set up, so the different classes are decoupled. I chose to include dagger despite the massive overhead compared to manual DI in a project of this scope because of the fact that it would scale better as this project would theoretically grow. In addition most other projects i have worked on don't leverage the dagger.android package so i wanted to check it out.
