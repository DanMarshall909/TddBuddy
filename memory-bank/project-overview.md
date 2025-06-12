# TddBuddy Project Overview

## What is TddBuddy?
TddBuddy is a JetBrains Rider plugin designed to support Test-Driven Development practices. The plugin provides enhanced TDD workflows and utilities within the Rider IDE environment.

## Architecture

### Multi-Language Plugin Structure
- **Frontend**: Kotlin (Rider plugin UI and logic)
- **Backend**: C# (.NET 8.0+ backend services)
- **Communication**: Protocol-based RPC communication between Kotlin and C#

### Key Components

#### Kotlin Frontend (`src/rider/`)
- **ProtocolCaller**: Service for making protocol calls to the C# backend
- **Plugin XML**: META-INF/plugin.xml defines the plugin structure
- **Generated Protocol Models**: Auto-generated communication interfaces

#### C# Backend (`src/dotnet/`)
- **MyRdHost**: C# host for handling protocol calls
- **ZoneMarker**: Rider plugin zone configuration
- **Model Classes**: Data transfer objects for protocol communication

#### Protocol Definition (`protocol/`)
- **RdTddBuddyModel**: Kotlin protocol model definitions
- Uses JetBrains RD (Reactive Distributed) protocol for cross-language communication

## Current State
- Basic plugin structure is in place
- Protocol communication scaffolding implemented
- Build system configured with Gradle
- Test infrastructure partially set up
- Ready for TDD feature implementation

## Development Environment
- **IDE**: JetBrains Rider (for C# development) + IntelliJ/VS Code (for Kotlin)
- **Build System**: Gradle with Kotlin DSL
- **Target Platform**: JetBrains Rider IDE
- **Minimum Requirements**: .NET SDK 8.0+

## Key Build Commands
- `./gradlew :buildPlugin` - Build plugin ZIP archive
- `./gradlew :runIde` - Launch test Rider instance with plugin
- `./gradlew :check` - Run all tests

## Next Development Priorities
1. Define specific TDD features and requirements
2. Implement core TDD workflow automation
3. Add comprehensive test coverage
4. Develop user interface components
5. Integration testing with real Rider instances
