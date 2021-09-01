![groovestock logo](images/groovestock_logo.png)
# GrooveStock
GrooveStock is a simple, clean app to keep track of your vinyl, cd's, cassettes, & mp3's. I am building this repository in stages to highlight newer libraries available within the Android ecosystem and to incrementally add functionality to the app.

## Stage One.
In this stage I am building the basic skeleton of the app: Model, UI, XML layouts, Activities, Fragments, ViewModels, LiveData, RecyclerViews, and Adapters. I am using a single Activity with 3 Fragments that get swapped out within a single FrameLayout. Here, I am beginning to use Android Jetpack: a collection of libraries that allow for concise, organized code that will guide the rest of the project. The ViewModel component that is part of Jetpack allows for an MVVM (Model-View-ViewModel) structure to be the organizing architecture (later in the project I plan on implementing an MVI architecture to replace the MVVM structure). The ViewModel classes will use LiveData to hold the data for the UI to observe. The ViewModels will ensure that the state of the Activities and Fragments will survive configuration changes.
