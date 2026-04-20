# Low-Level Design — Patterns, Problems & Demos

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.oracle.com/java/)
[![Python](https://img.shields.io/badge/Python-3776AB?style=for-the-badge&logo=python&logoColor=white)](https://www.python.org/)
[![Design Patterns](https://img.shields.io/badge/Design_Patterns-Gang_of_Four-blue?style=for-the-badge)](https://en.wikipedia.org/wiki/Design_Patterns)

Java implementations of common **design patterns**, small **low-level design (LLD) exercises**, and a **Python voice spelling demo** (`spellbee_voice_bot`). Source roots under `src/`; IntelliJ module file: `system-design.iml`.

## Table of contents

- [Overview](#overview)
- [Repository layout](#repository-layout)
- [Design patterns](#design-patterns)
- [LLD problem solutions](#lld-problem-solutions)
- [Spell Bee voice bot (Python)](#spell-bee-voice-bot-python)
- [Build and run (Java)](#build-and-run-java)
- [Contributing](#contributing)
- [Author](#author)

## Overview

- **Design patterns** — Creational, structural, and behavioral examples with `Main` (or `main`) drivers under `src/LLD/designpatterns/`.
- **LLD problems** — Self-contained mini-designs (tic-tac-toe, vending machine, URL shortener) under `src/LLD/lldproblems/`.
- **Spell Bee voice bot** — Pipecat-based voice game; see the [package README](src/LLD/spellbee_voice_bot/README.md).

## Repository layout

```
Low-Level-Designs/
├── src/
│   ├── LLD/
│   │   ├── designpatterns/          # Pattern demos (strategy, factory, …)
│   │   ├── lldproblems/             # LLD exercises
│   │   │   ├── tictactoe/
│   │   │   ├── vendingmachine/      # State + payment strategies
│   │   │   └── urlshortner/         # Short URLs, Base62, in-memory store
│   │   ├── spellbee_voice_bot/      # Python: voice spelling (Pipecat, etc.)
│   │   └── Main.java
│   └── main.java
├── system-design.iml                # IntelliJ module (source root: src/)
└── README.md
```

## Design patterns

| Pattern | Category | Package / folder |
|--------|----------|-------------------|
| Strategy | Behavioral | `designpatterns/strategy/` |
| Factory | Creational | `designpatterns/factory/` |
| Abstract Factory | Creational | `designpatterns/abstractfactory/` |
| Builder | Creational | `designpatterns/builderpattern/` |
| Decorator | Structural | `designpatterns/Decorator/` |
| Observer | Behavioral | `designpatterns/observer/` |
| Chain of Responsibility | Behavioral | `designpatterns/cor/` |
| Null Object | Behavioral | `designpatterns/nullobjectpattern/` |
| Adapter | Structural | `designpatterns/adapterpattern/` |
| Facade | Structural | `designpatterns/facadepattern/` |
| Proxy (virtual / protection / remote) | Structural | `designpatterns/proxypattern/` |

Entry points are typically `Main.java` or `main.java` inside each package; compile with `src` on the classpath and run using the fully qualified class name.

## LLD problem solutions

| Topic | Location | Notes |
|-------|----------|--------|
| Tic-tac-toe | `lldproblems/tictactoe/` | Board, players, game loop (`main.java`) |
| Vending machine | `lldproblems/vendingmachine/` | State pattern + payment strategies |
| URL shortener | `lldproblems/urlshortner/` | Encode/decode, repository abstraction |

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

## Build and run (Java)

**Prerequisites:** `javac` / `java` on your `PATH`. Most modules work with **Java 8+**; **tic-tac-toe** uses newer APIs (e.g. `Stream.toList()`), so use **Java 17+** recommended for the whole tree.

**Clone**

```bash
git clone https://github.com/stuck-in-a-local-optimum/Low-Level-Designs.git
cd Low-Level-Designs
```

**Examples** (from repo root; classpath is `src`):

```bash
# Strategy
javac -cp src src/LLD/designpatterns/strategy/Main.java
java -cp src LLD.designpatterns.strategy.Main

# Factory (class file is main)
javac -cp src src/LLD/designpatterns/factory/main.java
java -cp src LLD.designpatterns.factory.main

# Abstract factory
javac -cp src src/LLD/designpatterns/abstractfactory/main.java
java -cp src LLD.designpatterns.abstractfactory.main

# Vending machine (LLD)
javac -cp src src/LLD/lldproblems/vendingmachine/Main.java
java -cp src LLD.lldproblems.vendingmachine.Main

# URL shortener
javac -cp src src/LLD/lldproblems/urlshortner/Main.java
java -cp src LLD.lldproblems.urlshortner.Main

# Tic-tac-toe (entry class name is lowercase `main`)
javac -cp src src/LLD/lldproblems/tictactoe/main.java
java -cp src LLD.lldproblems.tictactoe.main
```

For packages with many files, compile all sources in the folder, for example:

```bash
javac -cp src $(find src/LLD/designpatterns/proxypattern -name "*.java")
java -cp src LLD.designpatterns.proxypattern.Main
```

Adjust `find` usage on Windows (PowerShell) or compile from your IDE using `src` as the source root.

## Contributing

1. Fork the repository  
2. Create a branch (`git checkout -b feature/your-change`)  
3. Commit with clear messages  
4. Open a pull request  

Match existing package naming and style; keep demos runnable from the `src` classpath.

## Author

**stuck-in-a-local-optimum**  
GitHub: [@stuck-in-a-local-optimum](https://github.com/stuck-in-a-local-optimum)
