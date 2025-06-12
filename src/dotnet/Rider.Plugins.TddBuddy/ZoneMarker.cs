using JetBrains.Application.BuildScript.Application.Zones;
using JetBrains.ProjectModel;

namespace Rider.Plugins.TddBuddy;

[ZoneMarker]
public class ZoneMarker : IRequire<IProjectModelZone>;
