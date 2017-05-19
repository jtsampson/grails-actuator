package org.marley.mae.actuator

import grails.converters.JSON

class ActuatorController {

    ActuatorController() {
        JSON.createNamedConfig('PASS-THROUGH-JSON') {
            it.registerObjectMarshaller(String) {  ->
                it.toString()
            }
        }
    }

    static responseFormats = ['json','xml']
    // static allowedMethods = [info: "GET",
    //                          metrics: 'GET',
    //                         env: 'GET']
    def beanService
    def envService
    def heapDumpService
    def infoService
    def mappingService
    def metricService

    def actuator() {
        //TODO
    }

    def beans(){
        respond beanService.collectBeans()
    }

    def configprops(){
        //TODO
    }

    def heapdump() {
        respond heapDumpService.dumpIt(params?.live ?: true)
    }

    def env() {
        respond envService.collectEnvironment()
    }

    def info() {
        respond infoService.collectInfo()
    }

    def mappings() {
        respond mappingService.collectMappings()
    }

    def metrics() {
        respond metricService.collectMetrics()
    }
}
