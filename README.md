# spring-websocket-example
Demo project for Spring Websocket

# Steps
1. Create / Register the end-point to make the socket connection between client & server
   (STOMP - Seeming Text Oriented Messaging Protocol)

    Need a class extending with AbstractWebSocketMessageBrokerConfigurer
   `@Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/greeting");
    }`

So any client need to a hit to this "/greeting" to establish a socket connection.
Need to annotate it with @EnableWebSocketMessageBroker

2. Create a message broke
    Enable a simple message broker and configure one or more prefixes to filter destinations targeting the broker

   `@Override
   public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic/", "/queue/");
        config.setApplicationDestinationPrefixes("/app");
   }`

    In this case we configure two channels ("topic & queue") and root destination as "/app"


3. Crate a controller to push/ Publish messages to a channel(s)

   `@MessageMapping("/message")
   @SendToUser("/queue/reply")
   public String processMessageFromClient(@Payload String message, Principal principal) throws Exception {
        String name = new Gson().fromJson(message, Map.class).get("name").toString();
        //messagingTemplate.convertAndSendToUser(principal.getName(), "/queue/reply", name);
        return name;
   }`
    


