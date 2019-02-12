# my-own-simple-todo

A [re-frame](https://github.com/Day8/re-frame) application designed to ... well, that part is up to you.

Original verison: [reframe-client](https://github.com/tacticiankerala/re-frame-sample-app)

## Development Mode

### Run application:

```
lein clean
lein figwheel dev
```

Figwheel will automatically push cljs changes to the browser.

Wait a bit, then browse to [http://localhost:3449](http://localhost:3449).

## Production Build


To compile clojurescript to javascript:

```
lein clean
lein cljsbuild once min
```

## Docker

Build the image and run it:
```
docker build -t "simple-reframe-todo" .
docker run -d -p 8080:80 simple-reframe-todo
```

## upcomming Task

- [ ] add "edit"-Funktion
- [ ] press "enter" to add
- [ ] format creationdate
- [ ] responsive design
- [ ] database
- [ ] pwa, offline, serviceworker,..  
- [ ] some async ajax calls.. 