# NASA API Project

This is a group project to access data from the Mars Rover Images API. This API collects data from images take
by the Curiosity, Opportunity and Spirit Rovers on Mars. Each rover has its own set of photos which can be
queried independently. The photos are organised by sol (a martian day) counting up from the Rovers landing date.
Along with querying by date, you can also query by the camera which took the photo.

There is a mission manifest for each rover at /manifests/rover_name. We will begin by querying the Curiosity
Rover.

## Getting Started

Before you get started you will need to request your own API Key
from https://api.nasa.gov/api.html#MarsPhotosand. You will need place it in a resource folder under a file
name api_key.properties.

## Environment

Intellij IDEA 2018.2.4

Maven Quickstart archetype

Java 11

## Testing

Unit tests currently under development using j-unit, hamcrest and rest assured. These tools will be used to test out
Key Reader, HTTPManager, JSONFactory, RoverPhotoParser.

## Authors

Sam Grill, Oliver Hall, John Shipman.