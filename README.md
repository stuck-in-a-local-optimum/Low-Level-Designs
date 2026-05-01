# Low-Level Design — Design Patterns & LLD Problems

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.oracle.com/java/)
[![Python](https://img.shields.io/badge/Python-3776AB?style=for-the-badge&logo=python&logoColor=white)](https://www.python.org/)
[![Design Patterns](https://img.shields.io/badge/Design_Patterns-Gang_of_Four-blue?style=for-the-badge)](https://en.wikipedia.org/wiki/Design_Patterns)

Java implementations of common **design patterns**, **LLD exercises** (URL shortener, **social network**, **CricInfo**, **pub/sub**), a small **hash map** demo, and a **Python voice spelling** sample (`spellbee_voice_bot`). Source lives under `src/`.

## Table of contents

- [Overview](#overview)
- [Repository layout](#repository-layout)
- [Design patterns](#design-patterns)
- [LLD solutions](#lld-solutions)
- [Spell Bee voice bot (Python)](#spell-bee-voice-bot-python)
- [Contributing](#contributing)
- [Author](#author)

## Overview

- **Design patterns** — Creational, structural, and behavioral examples with `Main` (or `main`) drivers under `src/LLD/designpatterns/`.
- **LLD** — URL shortener, social-network-style feed, CricInfo-style live scoring, and pub/sub messaging under `src/LLD/lldproblems/` (see [LLD solutions](#lld-solutions)).
- **Hash map** — Custom `MyHashMap` demo under `src/hashmap/`.
- **Spell Bee voice bot** — Pipecat-based voice game; see the [package README](src/LLD/spellbee_voice_bot/README.md).

Open the repo in your IDE with **`src`** as the Java source root (or clone with Git) and run entry classes from there. **JDK 8+** is enough for the Java modules shown here.

## Repository layout

```
Low-Level-Designs/
├── src/
│   ├── LLD/
│   │   ├── designpatterns/       # Pattern demos (strategy, factory, …)
│   │   ├── lldproblems/
│   │   │   ├── urlshortner/      # Short URLs, Base62, in-memory store
│   │   │   ├── socialnetwork/    # Users, friends, posts, feed, notifications
│   │   │   ├── cricinfo/         # Matches, ball updates, states, format strategies, live observers
│   │   │   └── pubsub/           # Topics, publish/subscribe, fan-out to subscribers
│   │   ├── spellbee_voice_bot/   # Python: voice spelling (Pipecat, etc.)
│   │   └── Main.java
│   └── hashmap/                  # Custom hash map implementation
└── README.md
```

## Design patterns

| Pattern | Category | Package / folder |
|--------|----------|-------------------|
| Strategy | Behavioral | `designpatterns/strategy/` |
| Factory | Creational | `designpatterns/factory/` |
| Abstract Factory | Creational | `designpatterns/abstractfactory/` |
| Decorator | Structural | `designpatterns/Decorator/` |
| Observer | Behavioral | `designpatterns/observer/` |
| Adapter | Structural | `designpatterns/adapterpattern/` |
| Facade | Structural | `designpatterns/facadepattern/` |
| Proxy (virtual / protection / remote) | Structural | `designpatterns/proxypattern/` |

Each pattern folder includes a runnable entry class (`Main` or `main`).

## LLD solutions

| Topic | Location | What it covers |
|-------|----------|----------------|
| URL shortener | `lldproblems/urlshortner/` | Long URL → short key, Base62-style encoding, in-memory repository. |
| Social network | `lldproblems/socialnetwork/` | User creation, friend connections, posts, comments, likes, chronological friend news feed, notifications on post / comment / like. |
| CricInfo | `lldproblems/cricinfo/` | Matches, teams, ball-by-ball updates, match state machine, format strategies (e.g. T20/ODI), observers for live scorecard and commentary. |
| Pub/sub | `lldproblems/pubsub/` | Topics, subscribe/unsubscribe, publish messages, fan-out delivery to subscribers. |

## Spell Bee voice bot (Python)

Voice spelling game using Pipecat, Deepgram, Gemini, and Cartesia. **Setup, env vars, and run instructions** are documented here:

**[src/LLD/spellbee_voice_bot/README.md](src/LLD/spellbee_voice_bot/README.md)**

Short version:

```bash
cd src/LLD/spellbee_voice_bot
python -m venv .venv && source .venv/bin/activate   # Windows: .venv\Scripts\activate
pip install -r requirements.txt
cp env.example .env   # then edit with your API keys
python server.py
```

## Contributing

1. Fork the repository  
2. Create a branch (`git checkout -b feature/your-change`)  
3. Commit with clear messages  
4. Open a pull request  

Match existing package naming and style; keep demos easy to run from the IDE.

## Author

**stuck-in-a-local-optimum**  
GitHub: [@stuck-in-a-local-optimum](https://github.com/stuck-in-a-local-optimum)
