package model.rider

import com.jetbrains.rd.generator.nova.*
import com.jetbrains.rd.generator.nova.PredefinedType.string
import com.jetbrains.rd.generator.nova.PredefinedType.int
import com.jetbrains.rd.generator.nova.PredefinedType.bool
import com.jetbrains.rd.generator.nova.csharp.CSharp50Generator
import com.jetbrains.rd.generator.nova.kotlin.Kotlin11Generator
import com.jetbrains.rider.model.nova.ide.SolutionModel

@Suppress("unused")
object RdTddBuddyModel : Ext(SolutionModel.Solution) {
    private val RdCallRequest = structdef {
        field("myField", string)
    }

    private val RdCallResponse = structdef {
        field("myResult", int)
    }

    private val TestStatusUpdate = structdef {
        field("hasFailedTests", bool)
        field("firstFailedTestName", string)
    }

    init {
        setting(Kotlin11Generator.Namespace, "com.jetbrains.rider.plugins.tddbuddy.model")
        setting(CSharp50Generator.Namespace, "Rider.Plugins.TddBuddy.Model")

        call("myCall", RdCallRequest, RdCallResponse)
            .doc("This is an example protocol call.")

        signal("testStatusUpdated", TestStatusUpdate)
    }
}
