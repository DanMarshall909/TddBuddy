# TddBuddy Project Overview

## What is TddBuddy?
TddBuddy is a JetBrains Rider plugin designed to support Test-Driven Development practices. The plugin provides enhanced TDD workflows and utilities within the Rider IDE environment.

**TddBuddy is a fresh start based on lessons learned from the RiderTddHelper2 project** (see [project-history.md](project-history.md) for detailed background).

## Core Philosophy: Simplified and Robust

### Key Principles
1. **Simplicity First**: Focus on essential 80/20 value (red border + test navigation)
2. **Stable APIs**: Use well-documented IntelliJ Platform APIs to avoid fragility
3. **TDD the Plugin**: Apply our own TDD principles during development
4. **Incremental Complexity**: Add features only after core is rock-solid

## Architecture

### Multi-Language Plugin Structure (Simplified)
- **Kotlin Frontend**: UI, test status tracking, navigation (primary focus)
- **C# Backend**: Minimal - .NET-specific test framework integration only
- **Protocol**: Simple request/response for test status updates (not complex RPC)

### Core Services (Simplified from RiderTddHelper2)

#### Kotlin Frontend (`src/rider/`)
- **TestStatusService**: Track pass/fail state (simplified from TestResultsTracker)
- **UIFeedbackService**: Handle red border and visual feedback
- **NavigationService**: Cycle through failed tests
- **ProtocolService**: Minimal communication with C# backend

#### C# Backend (`src/dotnet/`)
- **TestStatusProvider**: Simple .NET test status reporting
- **Protocol Handler**: Minimal RPC endpoint for test status

#### Protocol Definition (`protocol/`)
- **Simple Status Model**: Basic pass/fail status and test list
- Avoid complex RD protocol - use simple JSON/protobuf for reliability

## Current State
- **Project Structure**: ✅ Established with proper multi-language setup
- **Build System**: ✅ Gradle configuration in place
- **Protocol Scaffolding**: ✅ Basic communication framework ready
- **Ready for Implementation**: Core TDD features

## Development Environment
- **Primary IDE**: VS Code with Cline (for exploration and rapid development)
- **Secondary IDE**: JetBrains Rider (for complex C# debugging when needed)
- **Build System**: Gradle with Kotlin DSL
- **Target Platform**: JetBrains Rider IDE
- **Requirements**: .NET SDK 8.0+, Java 17+

## Key Build Commands
- `./gradlew :buildPlugin` - Build plugin ZIP archive
- `./gradlew :runIde` - Launch test Rider instance with plugin
- `./gradlew :check` - Run all tests (when test infrastructure is stable)

## Implementation Roadmap (Revised from RiderTddHelper2)

### Phase 1: Core Value (High ROI) 🎯
**Focus**: Get the essential TDD feedback loop working reliably
1. **Test Status Tracking**: Detect when tests pass/fail
2. **Red Border Feedback**: Visual indicator in IDE when tests fail
3. **Failed Test Navigation**: Keyboard shortcut to cycle through failures
4. **Basic Protocol**: Simple communication between Kotlin and C#

**Success Criteria**: Plugin provides immediate visual feedback and test navigation

### Phase 2: Polish and Configuration 🔧
**Focus**: Make the core functionality configurable and robust
1. **Display Options**: Configure how test failures are shown
2. **Performance Optimization**: Ensure minimal impact on IDE performance
3. **Enhanced UI Feedback**: Test names in title bar, better visual indicators
4. **Error Handling**: Graceful handling of edge cases

**Success Criteria**: Plugin is stable, configurable, and performs well

### Future Phases: Advanced Features (If Needed) ⚡
1. **Auto-Test Runner**: Automatic test execution on idle detection
2. **Extension Points**: Allow community extensions
3. **Advanced Integrations**: Support for multiple test frameworks

## Lessons Applied from RiderTddHelper2

### ✅ What We're Keeping
- Service-oriented architecture (simplified)
- Event-based communication (where appropriate)
- Clear feature specifications
- Multi-language approach

### 🚫 What We're Avoiding
- Over-engineered abstraction layers
- Complex 4-phase implementation plans
- Reflection-based API workarounds
- Fragile test infrastructure (initially)

### 🔧 Technical Decisions
- **Start with manual testing** until plugin core is stable
- **Use proven Gradle patterns** from existing successful plugins
- **Focus on stable IntelliJ Platform APIs** documented in official guides
- **Keep C# backend minimal** to reduce complexity

## Success Metrics

### Phase 1 Success
- Red border appears reliably when tests fail
- Navigation to failed tests works consistently
- Plugin builds and installs without issues
- Performance impact is unnoticeable

### Long-term Success
- Plugin remains stable across Rider updates
- Codebase is maintainable and extendable
- Positive user feedback and adoption
- Successful JetBrains Marketplace publication

## Plugin Infrastructure (as of 2025-06-12)

- Rider plugin structure established with Kotlin and .NET interop.
- CI and Release workflows set up for automated builds and publishing.
- `plugin.xml` defines plugin metadata, version, and registers a startup activity.
- On IDE startup, a red border is shown for demo/testing (via `UIFeedbackStartupActivity`).
- Ready for further TDD feedback loop integration and protocol wiring.
