# WIP: yelp-reviews-analysis-api-java
<h2>Yelp API with Cloud Vision and Google Natural Language API.</h2>
<p>Retrieves reviews from any businesses using the <strong>Yelp API</strong> and analyzes its reviews using <strong>Google Natural Language API</strong> (sentiment analysis) and <strong>Cloud Vision API</strong> (image analysis - face detection).</p> 

<h4>Features</h4>
<ul>
    <li>Sequential API Calls to <em>Yelp Business Search API</em> and <em>Yelp Reviews API</em></li>
    <li>Parallel API Calls to <em>Cloud Vision API</em> and <em>Natural Language API</em></li>
</ul>

<h4>To Dos</h4>
<ul>
    <li><strike>Functional Implementation</strike></li>
    <li>Unit Tests</li>
    <li>Documentation on how to use/run</li>
</ul>

**REQUEST:**
```curl
curl --location --request GET 'localhost:8080/yelp/business/reviews?location=Milwaukee'
```

**RESPONSE:**
```json
{
    "businesses": [
        {
            "name": "Blue's Egg - Milwaukee",
            "reviews": [
                {
                    "text": "Yes so good the food is always good no matter what you get. But the service is also good. With COVID I order curbside and you pull up to the back doo and...",
                    "imageUrl": "https://s3-media2.fl.yelpcdn.com/photo/CZiatTwuTB1UYWcTmtugSw/o.jpg",
                    "analysis": {
                        "emotions": [
                            {
                                "joyLikelihood": "VERY_LIKELY",
                                "sorrowLikelihood": "VERY_UNLIKELY",
                                "angerLikelihood": "VERY_UNLIKELY",
                                "surpriseLikelihood": "VERY_UNLIKELY"
                            },
                            {
                                "joyLikelihood": "LIKELY",
                                "sorrowLikelihood": "VERY_UNLIKELY",
                                "angerLikelihood": "VERY_UNLIKELY",
                                "surpriseLikelihood": "VERY_UNLIKELY"
                            },
                            {
                                "joyLikelihood": "VERY_LIKELY",
                                "sorrowLikelihood": "VERY_UNLIKELY",
                                "angerLikelihood": "VERY_UNLIKELY",
                                "surpriseLikelihood": "VERY_UNLIKELY"
                            }
                        ],
                        "sentiments": {
                            "documentSentiment": {
                                "magnitude": 1.6,
                                "score": 0.3
                            },
                            "language": "en",
                            "sentences": [
                                {
                                    "text": {
                                        "content": "Yes so good the food is always good no matter what you get.",
                                        "beginOffset": -1
                                    },
                                    "sentiment": {
                                        "magnitude": 0.9,
                                        "score": 0.9
                                    }
                                },
                                {
                                    "text": {
                                        "content": "But the service is also good.",
                                        "beginOffset": -1
                                    },
                                    "sentiment": {
                                        "magnitude": 0.3,
                                        "score": 0.3
                                    }
                                },
                                {
                                    "text": {
                                        "content": "With COVID I order curbside and you pull up to the back doo and...",
                                        "beginOffset": -1
                                    },
                                    "sentiment": {
                                        "magnitude": 0.3,
                                        "score": -0.3
                                    }
                                }
                            ]
                        }
                    }
                },
                {
                    "text": "Blue's Egg was doing appropriate social distancing and had screens between tables. Our server was very friendly, helpful, and he made good recommendations....",
                    "imageUrl": "https://s3-media2.fl.yelpcdn.com/photo/oU0TG1v-Doq7Mx_MghO1nA/o.jpg",
                    "analysis": {
                        "emotions": [
                            {
                                "joyLikelihood": "VERY_LIKELY",
                                "sorrowLikelihood": "VERY_UNLIKELY",
                                "angerLikelihood": "VERY_UNLIKELY",
                                "surpriseLikelihood": "VERY_UNLIKELY"
                            }
                        ],
                        "sentiments": {
                            "documentSentiment": {
                                "magnitude": 1.0,
                                "score": 0.5
                            },
                            "language": "en",
                            "sentences": [
                                {
                                    "text": {
                                        "content": "Blue's Egg was doing appropriate social distancing and had screens between tables.",
                                        "beginOffset": -1
                                    },
                                    "sentiment": {
                                        "magnitude": 0.1,
                                        "score": 0.1
                                    }
                                },
                                {
                                    "text": {
                                        "content": "Our server was very friendly, helpful, and he made good recommendations....",
                                        "beginOffset": -1
                                    },
                                    "sentiment": {
                                        "magnitude": 0.9,
                                        "score": 0.9
                                    }
                                }
                            ]
                        }
                    }
                },
                {
                    "text": "Always top quality, and it dies not matter what you get.  Plus, the curbside service is smart and fast.",
                    "imageUrl": "https://s3-media2.fl.yelpcdn.com/photo/EYEATG96BFQ6DSLWtrScYw/o.jpg",
                    "analysis": {
                        "emotions": [
                            {
                                "joyLikelihood": "VERY_UNLIKELY",
                                "sorrowLikelihood": "VERY_UNLIKELY",
                                "angerLikelihood": "VERY_UNLIKELY",
                                "surpriseLikelihood": "LIKELY"
                            }
                        ],
                        "sentiments": {
                            "documentSentiment": {
                                "magnitude": 1.9,
                                "score": 0.9
                            },
                            "language": "en",
                            "sentences": [
                                {
                                    "text": {
                                        "content": "Always top quality, and it dies not matter what you get.",
                                        "beginOffset": -1
                                    },
                                    "sentiment": {
                                        "magnitude": 0.9,
                                        "score": 0.9
                                    }
                                },
                                {
                                    "text": {
                                        "content": "Plus, the curbside service is smart and fast.",
                                        "beginOffset": -1
                                    },
                                    "sentiment": {
                                        "magnitude": 0.9,
                                        "score": 0.9
                                    }
                                }
                            ]
                        }
                    }
                }
            ]
        },
        {
            "name": "Story Hill BKC",
            "reviews": [
                {
                    "text": "The hubby and I felt like treating ourselves to a Friday lunch out! He'd never been to Story Hill, so I was excited to take him somewhere new.\n\nThey've done...",
                    "imageUrl": "https://s3-media4.fl.yelpcdn.com/photo/cPgiqe-VSa9CB8LbF7Iw9Q/o.jpg",
                    "analysis": {
                        "emotions": [
                            {
                                "joyLikelihood": "VERY_LIKELY",
                                "sorrowLikelihood": "VERY_UNLIKELY",
                                "angerLikelihood": "VERY_UNLIKELY",
                                "surpriseLikelihood": "VERY_UNLIKELY"
                            }
                        ],
                        "sentiments": {
                            "documentSentiment": {
                                "magnitude": 1.4,
                                "score": 0.4
                            },
                            "language": "en",
                            "sentences": [
                                {
                                    "text": {
                                        "content": "The hubby and I felt like treating ourselves to a Friday lunch out!",
                                        "beginOffset": -1
                                    },
                                    "sentiment": {
                                        "magnitude": 0.8,
                                        "score": 0.8
                                    }
                                },
                                {
                                    "text": {
                                        "content": "He'd never been to Story Hill, so I was excited to take him somewhere new.",
                                        "beginOffset": -1
                                    },
                                    "sentiment": {
                                        "magnitude": 0.5,
                                        "score": 0.5
                                    }
                                },
                                {
                                    "text": {
                                        "content": "They've done...",
                                        "beginOffset": -1
                                    },
                                    "sentiment": {
                                        "magnitude": 0.0,
                                        "score": 0.0
                                    }
                                }
                            ]
                        }
                    }
                },
                {
                    "text": "I ordered brunch for pick-up, and the service & food was still just as excellent as when I've dined inside. Ordering online was seamless, and they send...",
                    "imageUrl": "https://s3-media4.fl.yelpcdn.com/photo/ukJIeWWrW5F4T79yar2MZA/o.jpg",
                    "analysis": {
                        "emotions": [
                            {
                                "joyLikelihood": "VERY_LIKELY",
                                "sorrowLikelihood": "VERY_UNLIKELY",
                                "angerLikelihood": "VERY_UNLIKELY",
                                "surpriseLikelihood": "VERY_UNLIKELY"
                            }
                        ],
                        "sentiments": {
                            "documentSentiment": {
                                "magnitude": 1.6,
                                "score": 0.8
                            },
                            "language": "en",
                            "sentences": [
                                {
                                    "text": {
                                        "content": "I ordered brunch for pick-up, and the service & food was still just as excellent as when I've dined inside.",
                                        "beginOffset": -1
                                    },
                                    "sentiment": {
                                        "magnitude": 0.9,
                                        "score": 0.9
                                    }
                                },
                                {
                                    "text": {
                                        "content": "Ordering online was seamless, and they send...",
                                        "beginOffset": -1
                                    },
                                    "sentiment": {
                                        "magnitude": 0.7,
                                        "score": 0.7
                                    }
                                }
                            ]
                        }
                    }
                },
                {
                    "text": "Storyhill is one of my favorite places for brunch, especially during COVID now. They have nice glass dividers up so you feel like you have your own little...",
                    "imageUrl": "https://s3-media3.fl.yelpcdn.com/photo/e0RNwi8LS55M4IXztC8NqQ/o.jpg",
                    "analysis": {
                        "emotions": [
                            {
                                "joyLikelihood": "VERY_UNLIKELY",
                                "sorrowLikelihood": "VERY_UNLIKELY",
                                "angerLikelihood": "VERY_UNLIKELY",
                                "surpriseLikelihood": "VERY_UNLIKELY"
                            }
                        ],
                        "sentiments": {
                            "documentSentiment": {
                                "magnitude": 1.7,
                                "score": 0.8
                            },
                            "language": "en",
                            "sentences": [
                                {
                                    "text": {
                                        "content": "Storyhill is one of my favorite places for brunch, especially during COVID now.",
                                        "beginOffset": -1
                                    },
                                    "sentiment": {
                                        "magnitude": 0.9,
                                        "score": 0.9
                                    }
                                },
                                {
                                    "text": {
                                        "content": "They have nice glass dividers up so you feel like you have your own little...",
                                        "beginOffset": -1
                                    },
                                    "sentiment": {
                                        "magnitude": 0.8,
                                        "score": 0.8
                                    }
                                }
                            ]
                        }
                    }
                }
            ]
        },
        {
            "name": "St Paul Fish Company",
            "reviews": [
                {
                    "text": "Wow!!! Just wow!!! I was definitely impressed with this spot!! I went to Milwaukee randomly for a day and after walking around, I decided to try this place...",
                    "imageUrl": "https://s3-media2.fl.yelpcdn.com/photo/UU7f3hzMQev_-3fJ7DJPXg/o.jpg",
                    "analysis": {
                        "emotions": [
                            {
                                "joyLikelihood": "VERY_LIKELY",
                                "sorrowLikelihood": "VERY_UNLIKELY",
                                "angerLikelihood": "VERY_UNLIKELY",
                                "surpriseLikelihood": "VERY_UNLIKELY"
                            }
                        ],
                        "sentiments": {
                            "documentSentiment": {
                                "magnitude": 3.3,
                                "score": 0.8
                            },
                            "language": "en",
                            "sentences": [
                                {
                                    "text": {
                                        "content": "Wow!!!",
                                        "beginOffset": -1
                                    },
                                    "sentiment": {
                                        "magnitude": 0.9,
                                        "score": 0.9
                                    }
                                },
                                {
                                    "text": {
                                        "content": "Just wow!!!",
                                        "beginOffset": -1
                                    },
                                    "sentiment": {
                                        "magnitude": 0.9,
                                        "score": 0.9
                                    }
                                },
                                {
                                    "text": {
                                        "content": "I was definitely impressed with this spot!!",
                                        "beginOffset": -1
                                    },
                                    "sentiment": {
                                        "magnitude": 0.9,
                                        "score": 0.9
                                    }
                                },
                                {
                                    "text": {
                                        "content": "I went to Milwaukee randomly for a day and after walking around, I decided to try this place...",
                                        "beginOffset": -1
                                    },
                                    "sentiment": {
                                        "magnitude": 0.4,
                                        "score": 0.4
                                    }
                                }
                            ]
                        }
                    }
                },
                {
                    "text": "I just realized that I'm updating more reviews than actually making new ones... but covid does make it harder to try new places. And St. Paul's definitely...",
                    "imageUrl": "https://s3-media2.fl.yelpcdn.com/photo/c1-pflan5GgTqZmRa9Mt9Q/o.jpg",
                    "analysis": {
                        "emotions": [
                            {
                                "joyLikelihood": "VERY_LIKELY",
                                "sorrowLikelihood": "VERY_UNLIKELY",
                                "angerLikelihood": "VERY_UNLIKELY",
                                "surpriseLikelihood": "VERY_UNLIKELY"
                            }
                        ],
                        "sentiments": {
                            "documentSentiment": {
                                "magnitude": 0.1,
                                "score": 0.0
                            },
                            "language": "en",
                            "sentences": [
                                {
                                    "text": {
                                        "content": "I just realized that I'm updating more reviews than actually making new ones... but covid does make it harder to try new places.",
                                        "beginOffset": -1
                                    },
                                    "sentiment": {
                                        "magnitude": 0.1,
                                        "score": 0.1
                                    }
                                },
                                {
                                    "text": {
                                        "content": "And St. Paul's definitely...",
                                        "beginOffset": -1
                                    },
                                    "sentiment": {
                                        "magnitude": 0.0,
                                        "score": 0.0
                                    }
                                }
                            ]
                        }
                    }
                },
                {
                    "text": "Called ahead to place an order for pickup. They said it would be ready between 5-10 min.  Picked it up, brought it back to the hotel room, spread out the...",
                    "imageUrl": "https://s3-media4.fl.yelpcdn.com/photo/0UtUkuRD1pm-1VwyzGbgsA/o.jpg",
                    "analysis": {
                        "emotions": [
                            {
                                "joyLikelihood": "VERY_LIKELY",
                                "sorrowLikelihood": "VERY_UNLIKELY",
                                "angerLikelihood": "VERY_UNLIKELY",
                                "surpriseLikelihood": "VERY_UNLIKELY"
                            },
                            {
                                "joyLikelihood": "VERY_LIKELY",
                                "sorrowLikelihood": "VERY_UNLIKELY",
                                "angerLikelihood": "VERY_UNLIKELY",
                                "surpriseLikelihood": "VERY_UNLIKELY"
                            }
                        ],
                        "sentiments": {
                            "documentSentiment": {
                                "magnitude": 0.5,
                                "score": -0.1
                            },
                            "language": "en",
                            "sentences": [
                                {
                                    "text": {
                                        "content": "Called ahead to place an order for pickup.",
                                        "beginOffset": -1
                                    },
                                    "sentiment": {
                                        "magnitude": 0.2,
                                        "score": -0.2
                                    }
                                },
                                {
                                    "text": {
                                        "content": "They said it would be ready between 5-10 min.",
                                        "beginOffset": -1
                                    },
                                    "sentiment": {
                                        "magnitude": 0.2,
                                        "score": -0.2
                                    }
                                },
                                {
                                    "text": {
                                        "content": "Picked it up, brought it back to the hotel room, spread out the...",
                                        "beginOffset": -1
                                    },
                                    "sentiment": {
                                        "magnitude": 0.0,
                                        "score": 0.0
                                    }
                                }
                            ]
                        }
                    }
                }
            ]
        }
    ]
}
```
