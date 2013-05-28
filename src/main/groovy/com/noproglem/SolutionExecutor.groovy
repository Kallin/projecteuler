package com.noproglem

class SolutionExecutor {

    final static DEFAULT_RUN_COUNT = 1

    static long timeCode(Closure timedCode) {
        def before = System.currentTimeMillis()
        timedCode.call()
        def after = System.currentTimeMillis()
        after - before
    }

    public static void main(String[] args) {
        def runCount = args ? args[0].toInteger() : DEFAULT_RUN_COUNT

        def skippedProblems = (0..0)
        final problems = (1..11).toList()
        problems.removeAll(skippedProblems)
        problems.each {
            def totalDuration = 0

            def runTimes = []

            Problem problem = java.lang.Class.forName("com.noproglem.Problem$it").newInstance()

            runCount.times {
                final executionTime = timeCode {
                    assert problem.answer == problem.solution1()
                }
                runTimes << executionTime
                totalDuration += executionTime
            }

            def avgTime = totalDuration / runCount
            println "average time for problem$it: $avgTime ms"
            println "execution times: $runTimes"
        }
    }

}