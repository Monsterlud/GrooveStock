![groovestock applogo](images/groovestock_applogo.png)
# GrooveStock
GrooveStock is a simple, clean app to keep track of your vinyl, cd's, cassettes, & mp3's. This app is being built in stages to showcase various libraries and frameworks. Each stage will add additional functionality to the application.

## Design.
![groovestock wireframe](images/groovestock_wireframe.png)
![groovestock material themes](images/groovestock_materialthemes.png) ![groovestock_color demo](images/groovestock_materialdemo.png)

## Stage One.
In this stage I am building the basic skeleton of the app: Model, UI, XML layouts, Activities, Fragments, ViewModels, and Adapters. I am using a single Activity with 3 Fragments that get swapped out within a single FragmentContainer. 

Here, I am beginning to use Android Jetpack: a collection of libraries that allow for the concise, organized code that will guide the rest of the project. The ViewModel component that is part of Jetpack allows for an MVVM (Model-View-ViewModel) structure to be the organizing architecture. The ViewModel classes will use LiveData to hold the data for the UI to observe. The ViewModels will ensure that the state of the Activities and Fragments will survive configuration changes and are fully LifeCycle aware. I will not be integrating the REST/API functionality in this stage. 

![groovestock architecture](images/groovestock_architecture.png)


