# WIP: yelp-reviews-analysis-api-java
<h2>Yelp API with Cloud Vision and Google Natural Language API.</h2>
<p>Retrieves reviews from any businesses using the <strong>Yelp API</strong> and analyzes its reviews using <strong>Google Natural Language API</strong> (sentiment analysis) and <strong>Cloud Vision API.</strong></p>

**REQUEST:**
```curl
curl --location --request GET 'localhost:8080/yelp/business/reviews?location=Milwaukee'
```

**RESPONSE:**
```json
{
    "total": 2400,
    "businesses": [
        {
            "id": "BIMfFGsAHjzvjSTcJWuJwQ",
            "name": "Blue's Egg - Milwaukee",
            "alias": "blues-egg-milwaukee-milwaukee",
            "rating": 4.5,
            "price": "$$",
            "phone": "+14142993180",
            "is_closed": false,
            "categories": [
                {
                    "alias": "breakfast_brunch",
                    "title": "Breakfast & Brunch"
                },
                {
                    "alias": "tradamerican",
                    "title": "American (Traditional)"
                }
            ],
            "review_count": 1635,
            "url": "https://www.yelp.com/biz/blues-egg-milwaukee-milwaukee?adjust_creative=9bpn8CEy69vXX__kLpifFQ&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=9bpn8CEy69vXX__kLpifFQ",
            "coordinates": {
                "latitude": 43.03427687646482,
                "longtitutde": null
            },
            "image_url": "https://s3-media1.fl.yelpcdn.com/bphoto/akWUb6VGyGxu7_yDMe1ICg/o.jpg",
            "location": {
                "address1": "317 N 76th St",
                "address2": "",
                "address3": "",
                "city": "Milwaukee",
                "country": "US",
                "state": "WI",
                "zip_code": "53213"
            },
            "distance": 4372.555978800949,
            "transactions": [
                "restaurant_reservation",
                "delivery"
            ]
        },
        {
            "id": "2gsMqFEpjfJemtcMLyvqqg",
            "name": "Story Hill BKC",
            "alias": "story-hill-bkc-milwaukee",
            "rating": 4.5,
            "price": "$$",
            "phone": "+14145394424",
            "is_closed": false,
            "categories": [
                {
                    "alias": "newamerican",
                    "title": "American (New)"
                },
                {
                    "alias": "beer_and_wine",
                    "title": "Beer, Wine & Spirits"
                },
                {
                    "alias": "wine_bars",
                    "title": "Wine Bars"
                }
            ],
            "review_count": 630,
            "url": "https://www.yelp.com/biz/story-hill-bkc-milwaukee?adjust_creative=9bpn8CEy69vXX__kLpifFQ&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=9bpn8CEy69vXX__kLpifFQ",
            "coordinates": {
                "latitude": 43.0368978590487,
                "longtitutde": null
            },
            "image_url": "https://s3-media2.fl.yelpcdn.com/bphoto/xopMAZ75azcZxW6_TEYvDw/o.jpg",
            "location": {
                "address1": "5100 W Bluemound Rd",
                "address2": "",
                "address3": "",
                "city": "Milwaukee",
                "country": "US",
                "state": "WI",
                "zip_code": "53208"
            },
            "distance": 1912.4339764418646,
            "transactions": [
                "restaurant_reservation",
                "delivery"
            ]
        },
        {
            "id": "bgjKz2S_7LikPMsy9LvGcQ",
            "name": "St Paul Fish Company",
            "alias": "st-paul-fish-company-milwaukee",
            "rating": 4.5,
            "price": "$$",
            "phone": "+14142208383",
            "is_closed": false,
            "categories": [
                {
                    "alias": "seafood",
                    "title": "Seafood"
                },
                {
                    "alias": "seafoodmarkets",
                    "title": "Seafood Markets"
                }
            ],
            "review_count": 890,
            "url": "https://www.yelp.com/biz/st-paul-fish-company-milwaukee?adjust_creative=9bpn8CEy69vXX__kLpifFQ&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=9bpn8CEy69vXX__kLpifFQ",
            "coordinates": {
                "latitude": 43.03524,
                "longtitutde": null
            },
            "image_url": "https://s3-media1.fl.yelpcdn.com/bphoto/5uaOK5HdyED1diKXON5iiw/o.jpg",
            "location": {
                "address1": "400 N Water St",
                "address2": "",
                "address3": "",
                "city": "Milwaukee",
                "country": "US",
                "state": "WI",
                "zip_code": "53202"
            },
            "distance": 3892.592718507035,
            "transactions": [
                "delivery"
            ]
        },
        {
            "id": "zKTGApTqlSDP1Gv4iRO29g",
            "name": "Odd Duck",
            "alias": "odd-duck-milwaukee",
            "rating": 4.5,
            "price": "$$",
            "phone": "+14147635881",
            "is_closed": false,
            "categories": [
                {
                    "alias": "newamerican",
                    "title": "American (New)"
                },
                {
                    "alias": "vegetarian",
                    "title": "Vegetarian"
                },
                {
                    "alias": "tapasmallplates",
                    "title": "Tapas/Small Plates"
                }
            ],
            "review_count": 776,
            "url": "https://www.yelp.com/biz/odd-duck-milwaukee?adjust_creative=9bpn8CEy69vXX__kLpifFQ&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=9bpn8CEy69vXX__kLpifFQ",
            "coordinates": {
                "latitude": 43.0020227,
                "longtitutde": null
            },
            "image_url": "https://s3-media3.fl.yelpcdn.com/bphoto/M2dGNEY0v6LivyJxNwyJmA/o.jpg",
            "location": {
                "address1": "2352 S Kinnickinnic Ave",
                "address2": "",
                "address3": "",
                "city": "Milwaukee",
                "country": "US",
                "state": "WI",
                "zip_code": "53207"
            },
            "distance": 6092.060824813809,
            "transactions": [
                "delivery",
                "pickup"
            ]
        },
        {
            "id": "mgVA9tNReJqiUGx33nfqqQ",
            "name": "Swingin' Door Exchange",
            "alias": "swingin-door-exchange-milwaukee",
            "rating": 4.5,
            "price": "$$",
            "phone": "+14142768150",
            "is_closed": false,
            "categories": [
                {
                    "alias": "newamerican",
                    "title": "American (New)"
                },
                {
                    "alias": "pubs",
                    "title": "Pubs"
                }
            ],
            "review_count": 767,
            "url": "https://www.yelp.com/biz/swingin-door-exchange-milwaukee?adjust_creative=9bpn8CEy69vXX__kLpifFQ&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=9bpn8CEy69vXX__kLpifFQ",
            "coordinates": {
                "latitude": 43.0372865988308,
                "longtitutde": null
            },
            "image_url": "https://s3-media3.fl.yelpcdn.com/bphoto/nQglUY8Hik8W41OrJZ-s9Q/o.jpg",
            "location": {
                "address1": "219 E Michigan St",
                "address2": "",
                "address3": "",
                "city": "Milwaukee",
                "country": "US",
                "state": "WI",
                "zip_code": "53202"
            },
            "distance": 3846.5217010651345,
            "transactions": [
                "delivery",
                "pickup"
            ]
        },
        {
            "id": "tnf6a9ywrnwkV6cv5SrWnA",
            "name": "Oscar's Pub & Grill",
            "alias": "oscars-pub-and-grill-milwaukee",
            "rating": 4.5,
            "price": "$$",
            "phone": "+14148101820",
            "is_closed": false,
            "categories": [
                {
                    "alias": "newamerican",
                    "title": "American (New)"
                },
                {
                    "alias": "pubs",
                    "title": "Pubs"
                },
                {
                    "alias": "burgers",
                    "title": "Burgers"
                }
            ],
            "review_count": 732,
            "url": "https://www.yelp.com/biz/oscars-pub-and-grill-milwaukee?adjust_creative=9bpn8CEy69vXX__kLpifFQ&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=9bpn8CEy69vXX__kLpifFQ",
            "coordinates": {
                "latitude": 43.02456,
                "longtitutde": null
            },
            "image_url": "https://s3-media1.fl.yelpcdn.com/bphoto/BaLIysGslti7yBiz70gzIQ/o.jpg",
            "location": {
                "address1": "1712 W Pierce St",
                "address2": "",
                "address3": "",
                "city": "Milwaukee",
                "country": "US",
                "state": "WI",
                "zip_code": "53204"
            },
            "distance": 2528.1857858844382,
            "transactions": [
                "delivery"
            ]
        },
        {
            "id": "zNQ-kyaAJVPrIM5zvAn8Bw",
            "name": "La Merenda",
            "alias": "la-merenda-milwaukee",
            "rating": 4.5,
            "price": "$$",
            "phone": "+14143890125",
            "is_closed": false,
            "categories": [
                {
                    "alias": "tapas",
                    "title": "Tapas Bars"
                },
                {
                    "alias": "tapasmallplates",
                    "title": "Tapas/Small Plates"
                }
            ],
            "review_count": 602,
            "url": "https://www.yelp.com/biz/la-merenda-milwaukee?adjust_creative=9bpn8CEy69vXX__kLpifFQ&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=9bpn8CEy69vXX__kLpifFQ",
            "coordinates": {
                "latitude": 43.0229148864746,
                "longtitutde": null
            },
            "image_url": "https://s3-media2.fl.yelpcdn.com/bphoto/SlMMpX6OLutS-_WCEAl0QQ/o.jpg",
            "location": {
                "address1": "125 E National Ave",
                "address2": "",
                "address3": "",
                "city": "Milwaukee",
                "country": "US",
                "state": "WI",
                "zip_code": "53204"
            },
            "distance": 4190.5973197167295,
            "transactions": [
                "delivery"
            ]
        },
        {
            "id": "w_jOXFdqDB-SUoRePQjqYg",
            "name": "Glorioso's Italian Market",
            "alias": "gloriosos-italian-market-milwaukee",
            "rating": 4.5,
            "price": "$$",
            "phone": "+14142720540",
            "is_closed": false,
            "categories": [
                {
                    "alias": "delis",
                    "title": "Delis"
                },
                {
                    "alias": "italian",
                    "title": "Italian"
                },
                {
                    "alias": "intlgrocery",
                    "title": "International Grocery"
                }
            ],
            "review_count": 417,
            "url": "https://www.yelp.com/biz/gloriosos-italian-market-milwaukee?adjust_creative=9bpn8CEy69vXX__kLpifFQ&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=9bpn8CEy69vXX__kLpifFQ",
            "coordinates": {
                "latitude": 43.05275,
                "longtitutde": null
            },
            "image_url": "https://s3-media1.fl.yelpcdn.com/bphoto/WoWqgl4gTh9DPjggqqCwBw/o.jpg",
            "location": {
                "address1": "1011 E Brady St",
                "address2": "",
                "address3": "",
                "city": "Milwaukee",
                "country": "US",
                "state": "WI",
                "zip_code": "53202"
            },
            "distance": 4708.258527942996,
            "transactions": [
                "delivery"
            ]
        },
        {
            "id": "LmStpJvuRHETtEIelojA3w",
            "name": "Milwaukee Art Museum",
            "alias": "milwaukee-art-museum-milwaukee",
            "rating": 4.5,
            "price": null,
            "phone": "+14142243200",
            "is_closed": false,
            "categories": [
                {
                    "alias": "artmuseums",
                    "title": "Art Museums"
                }
            ],
            "review_count": 346,
            "url": "https://www.yelp.com/biz/milwaukee-art-museum-milwaukee?adjust_creative=9bpn8CEy69vXX__kLpifFQ&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=9bpn8CEy69vXX__kLpifFQ",
            "coordinates": {
                "latitude": 43.040076,
                "longtitutde": null
            },
            "image_url": "https://s3-media3.fl.yelpcdn.com/bphoto/-KtzoN_hCY2zq5wlkzEe6w/o.jpg",
            "location": {
                "address1": "700 N Art Museum Dr",
                "address2": "",
                "address3": "",
                "city": "Milwaukee",
                "country": "US",
                "state": "WI",
                "zip_code": "53202"
            },
            "distance": 4725.654720034735,
            "transactions": []
        },
        {
            "id": "poMcdF7PM-EmOdm327qsgA",
            "name": "Maxie's",
            "alias": "maxies-milwaukee",
            "rating": 4.0,
            "price": "$$",
            "phone": "+14142923969",
            "is_closed": false,
            "categories": [
                {
                    "alias": "southern",
                    "title": "Southern"
                },
                {
                    "alias": "bbq",
                    "title": "Barbeque"
                },
                {
                    "alias": "seafood",
                    "title": "Seafood"
                }
            ],
            "review_count": 748,
            "url": "https://www.yelp.com/biz/maxies-milwaukee?adjust_creative=9bpn8CEy69vXX__kLpifFQ&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=9bpn8CEy69vXX__kLpifFQ",
            "coordinates": {
                "latitude": 43.03162,
                "longtitutde": null
            },
            "image_url": "https://s3-media2.fl.yelpcdn.com/bphoto/nl7nxMiyeo6rATLjc-eeNw/o.jpg",
            "location": {
                "address1": "6732 W Fairview Ave",
                "address2": "",
                "address3": "",
                "city": "Milwaukee",
                "country": "US",
                "state": "WI",
                "zip_code": "53213"
            },
            "distance": 3593.5572218382326,
            "transactions": [
                "restaurant_reservation",
                "delivery"
            ]
        },
        {
            "id": "IlcrTJRfhH5UT_vnBTfXEA",
            "name": "Bryant's Cocktail Lounge",
            "alias": "bryants-cocktail-lounge-milwaukee",
            "rating": 4.5,
            "price": "$$",
            "phone": "+14143832620",
            "is_closed": false,
            "categories": [
                {
                    "alias": "lounges",
                    "title": "Lounges"
                },
                {
                    "alias": "cocktailbars",
                    "title": "Cocktail Bars"
                }
            ],
            "review_count": 369,
            "url": "https://www.yelp.com/biz/bryants-cocktail-lounge-milwaukee?adjust_creative=9bpn8CEy69vXX__kLpifFQ&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=9bpn8CEy69vXX__kLpifFQ",
            "coordinates": {
                "latitude": 43.014338,
                "longtitutde": null
            },
            "image_url": "https://s3-media1.fl.yelpcdn.com/bphoto/GoEcWkAjM8KG_EKUaanCaQ/o.jpg",
            "location": {
                "address1": "1579 S 9th St",
                "address2": "",
                "address3": "",
                "city": "Milwaukee",
                "country": "US",
                "state": "WI",
                "zip_code": "53204"
            },
            "distance": 4011.3429806052814,
            "transactions": []
        },
        {
            "id": "uJ6MGrmjfPOP9W0V2aBklQ",
            "name": "Leon's Frozen Custard",
            "alias": "leons-frozen-custard-milwaukee",
            "rating": 4.5,
            "price": "$",
            "phone": "+14143831784",
            "is_closed": false,
            "categories": [
                {
                    "alias": "icecream",
                    "title": "Ice Cream & Frozen Yogurt"
                }
            ],
            "review_count": 458,
            "url": "https://www.yelp.com/biz/leons-frozen-custard-milwaukee?adjust_creative=9bpn8CEy69vXX__kLpifFQ&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=9bpn8CEy69vXX__kLpifFQ",
            "coordinates": {
                "latitude": 42.987758,
                "longtitutde": null
            },
            "image_url": "https://s3-media3.fl.yelpcdn.com/bphoto/Tmp_2_lAxP25xtcObr3vzA/o.jpg",
            "location": {
                "address1": "3131 S 27th St",
                "address2": "",
                "address3": "",
                "city": "Milwaukee",
                "country": "US",
                "state": "WI",
                "zip_code": "53215"
            },
            "distance": 6006.762149980335,
            "transactions": []
        },
        {
            "id": "CQQSEErWC1bRsfmYnVpg8g",
            "name": "Bavette",
            "alias": "bavette-milwaukee",
            "rating": 4.5,
            "price": "$$",
            "phone": "+14142733375",
            "is_closed": false,
            "categories": [
                {
                    "alias": "butcher",
                    "title": "Butcher"
                },
                {
                    "alias": "sandwiches",
                    "title": "Sandwiches"
                }
            ],
            "review_count": 317,
            "url": "https://www.yelp.com/biz/bavette-milwaukee?adjust_creative=9bpn8CEy69vXX__kLpifFQ&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=9bpn8CEy69vXX__kLpifFQ",
            "coordinates": {
                "latitude": 43.0316600430091,
                "longtitutde": null
            },
            "image_url": "https://s3-media4.fl.yelpcdn.com/bphoto/Nv-3L30ljGuJHMr2LAuh-Q/o.jpg",
            "location": {
                "address1": "330 E Menomonee St",
                "address2": "",
                "address3": "",
                "city": "Milwaukee",
                "country": "US",
                "state": "WI",
                "zip_code": "53202"
            },
            "distance": 4142.916353212874,
            "transactions": [
                "delivery"
            ]
        },
        {
            "id": "z2XcXJD9K_d_bMzY_NEOFw",
            "name": "Mad Rooster Cafe",
            "alias": "mad-rooster-cafe-west-milwaukee",
            "rating": 4.5,
            "price": "$$",
            "phone": "+14142319120",
            "is_closed": false,
            "categories": [
                {
                    "alias": "cafes",
                    "title": "Cafes"
                },
                {
                    "alias": "breakfast_brunch",
                    "title": "Breakfast & Brunch"
                }
            ],
            "review_count": 1104,
            "url": "https://www.yelp.com/biz/mad-rooster-cafe-west-milwaukee?adjust_creative=9bpn8CEy69vXX__kLpifFQ&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=9bpn8CEy69vXX__kLpifFQ",
            "coordinates": {
                "latitude": 43.016344,
                "longtitutde": null
            },
            "image_url": "https://s3-media3.fl.yelpcdn.com/bphoto/Hg8RfwYnH31BHa5ZIG_WrQ/o.jpg",
            "location": {
                "address1": "4401 W Greenfield Ave",
                "address2": "",
                "address3": "",
                "city": "West Milwaukee",
                "country": "US",
                "state": "WI",
                "zip_code": "53214"
            },
            "distance": 3024.6057556111055,
            "transactions": [
                "delivery",
                "pickup"
            ]
        },
        {
            "id": "C4c7XBO05NuOeAbr0vAptA",
            "name": "SweetDiner",
            "alias": "sweetdiner-milwaukee",
            "rating": 4.0,
            "price": "$$",
            "phone": "+14144889600",
            "is_closed": false,
            "categories": [
                {
                    "alias": "diners",
                    "title": "Diners"
                },
                {
                    "alias": "breakfast_brunch",
                    "title": "Breakfast & Brunch"
                },
                {
                    "alias": "tradamerican",
                    "title": "American (Traditional)"
                }
            ],
            "review_count": 763,
            "url": "https://www.yelp.com/biz/sweetdiner-milwaukee?adjust_creative=9bpn8CEy69vXX__kLpifFQ&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=9bpn8CEy69vXX__kLpifFQ",
            "coordinates": {
                "latitude": 43.0327958694919,
                "longtitutde": null
            },
            "image_url": "https://s3-media4.fl.yelpcdn.com/bphoto/6gMk6bm8odTj2qx8gHdYHA/o.jpg",
            "location": {
                "address1": "239 E Chicago St",
                "address2": "Ste 103",
                "address3": null,
                "city": "Milwaukee",
                "country": "US",
                "state": "WI",
                "zip_code": "53202"
            },
            "distance": 3956.06179940891,
            "transactions": [
                "delivery",
                "pickup"
            ]
        },
        {
            "id": "fwqXo54zK_2Th0A5xAqZcg",
            "name": "AJ Bombers",
            "alias": "aj-bombers-milwaukee",
            "rating": 4.0,
            "price": "$$",
            "phone": "+14142219999",
            "is_closed": false,
            "categories": [
                {
                    "alias": "burgers",
                    "title": "Burgers"
                },
                {
                    "alias": "tradamerican",
                    "title": "American (Traditional)"
                }
            ],
            "review_count": 809,
            "url": "https://www.yelp.com/biz/aj-bombers-milwaukee?adjust_creative=9bpn8CEy69vXX__kLpifFQ&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=9bpn8CEy69vXX__kLpifFQ",
            "coordinates": {
                "latitude": 43.046797,
                "longtitutde": null
            },
            "image_url": "https://s3-media2.fl.yelpcdn.com/bphoto/ubQb9VeW66fvQ3APJvDKgQ/o.jpg",
            "location": {
                "address1": "1247 N Water St",
                "address2": "",
                "address3": "",
                "city": "Milwaukee",
                "country": "US",
                "state": "WI",
                "zip_code": "53202"
            },
            "distance": 3598.478646732162,
            "transactions": [
                "delivery",
                "pickup"
            ]
        },
        {
            "id": "p7OwdW-3kzwymVPUEqidiw",
            "name": "Café Corazón",
            "alias": "café-corazón-milwaukee-3",
            "rating": 4.5,
            "price": "$$",
            "phone": "+14148103941",
            "is_closed": false,
            "categories": [
                {
                    "alias": "mexican",
                    "title": "Mexican"
                },
                {
                    "alias": "breakfast_brunch",
                    "title": "Breakfast & Brunch"
                },
                {
                    "alias": "bars",
                    "title": "Bars"
                }
            ],
            "review_count": 560,
            "url": "https://www.yelp.com/biz/caf%C3%A9-coraz%C3%B3n-milwaukee-3?adjust_creative=9bpn8CEy69vXX__kLpifFQ&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=9bpn8CEy69vXX__kLpifFQ",
            "coordinates": {
                "latitude": 43.07549,
                "longtitutde": null
            },
            "image_url": "https://s3-media3.fl.yelpcdn.com/bphoto/EKhwNZMRAEtmGB0VCkMBug/o.jpg",
            "location": {
                "address1": "3129 N Bremen St",
                "address2": null,
                "address3": null,
                "city": "Milwaukee",
                "country": "US",
                "state": "WI",
                "zip_code": "53212"
            },
            "distance": 5827.776311330593,
            "transactions": [
                "delivery"
            ]
        },
        {
            "id": "dqsP3VWz4HVKV7R-EMzXKQ",
            "name": "Rice N Roll Bistro",
            "alias": "rice-n-roll-bistro-milwaukee",
            "rating": 4.5,
            "price": "$$",
            "phone": "+14142209944",
            "is_closed": false,
            "categories": [
                {
                    "alias": "sushi",
                    "title": "Sushi Bars"
                },
                {
                    "alias": "thai",
                    "title": "Thai"
                },
                {
                    "alias": "asianfusion",
                    "title": "Asian Fusion"
                }
            ],
            "review_count": 382,
            "url": "https://www.yelp.com/biz/rice-n-roll-bistro-milwaukee?adjust_creative=9bpn8CEy69vXX__kLpifFQ&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=9bpn8CEy69vXX__kLpifFQ",
            "coordinates": {
                "latitude": 43.0562591552734,
                "longtitutde": null
            },
            "image_url": "https://s3-media2.fl.yelpcdn.com/bphoto/x87j90-ewcHO0wQ6VSEoJQ/o.jpg",
            "location": {
                "address1": "1952 N Farwell Ave",
                "address2": "",
                "address3": "",
                "city": "Milwaukee",
                "country": "US",
                "state": "WI",
                "zip_code": "53202"
            },
            "distance": 5616.74743104839,
            "transactions": [
                "delivery",
                "pickup"
            ]
        },
        {
            "id": "DcX95tTrBjD1NA5f5Pyt3Q",
            "name": "Purple Door Ice Cream",
            "alias": "purple-door-ice-cream-milwaukee-2",
            "rating": 4.5,
            "price": "$",
            "phone": "+14149882521",
            "is_closed": false,
            "categories": [
                {
                    "alias": "icecream",
                    "title": "Ice Cream & Frozen Yogurt"
                }
            ],
            "review_count": 401,
            "url": "https://www.yelp.com/biz/purple-door-ice-cream-milwaukee-2?adjust_creative=9bpn8CEy69vXX__kLpifFQ&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=9bpn8CEy69vXX__kLpifFQ",
            "coordinates": {
                "latitude": 43.029226,
                "longtitutde": null
            },
            "image_url": "https://s3-media3.fl.yelpcdn.com/bphoto/q87oFpC6PkNelD4RcGJGdg/o.jpg",
            "location": {
                "address1": "205 S 2nd St",
                "address2": "",
                "address3": "",
                "city": "Milwaukee",
                "country": "US",
                "state": "WI",
                "zip_code": "53204"
            },
            "distance": 3693.7258164003424,
            "transactions": [
                "delivery"
            ]
        },
        {
            "id": "wmStGUk6Lqiqu2-maCGz5Q",
            "name": "Sobelman's Pub & Grill",
            "alias": "sobelmans-pub-and-grill-milwaukee",
            "rating": 4.0,
            "price": "$$",
            "phone": "+14149311919",
            "is_closed": false,
            "categories": [
                {
                    "alias": "pubs",
                    "title": "Pubs"
                },
                {
                    "alias": "tradamerican",
                    "title": "American (Traditional)"
                },
                {
                    "alias": "burgers",
                    "title": "Burgers"
                }
            ],
            "review_count": 789,
            "url": "https://www.yelp.com/biz/sobelmans-pub-and-grill-milwaukee?adjust_creative=9bpn8CEy69vXX__kLpifFQ&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=9bpn8CEy69vXX__kLpifFQ",
            "coordinates": {
                "latitude": 43.034992,
                "longtitutde": null
            },
            "image_url": "https://s3-media1.fl.yelpcdn.com/bphoto/28yTNK8ZrjIeFBXuTdNUvw/o.jpg",
            "location": {
                "address1": "1900 W St Paul Ave",
                "address2": "",
                "address3": "",
                "city": "Milwaukee",
                "country": "US",
                "state": "WI",
                "zip_code": "53233"
            },
            "distance": 1659.4190079279317,
            "transactions": [
                "delivery"
            ]
        }
    ],
    "region": {
        "center": {
            "latitude": 43.04160973514253,
            "longitude": -87.95516967773438
        }
    }
}
```
