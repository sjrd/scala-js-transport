package transport.jsapi

import scala.scalajs.js

class RTCConfiguration extends js.Object {
  var iceServers: js.Array[RTCIceServer] = js.native
}

object RTCConfiguration extends js.Object {
}

class RTCIceServer extends js.Object {
  var url: js.String = js.native
  var credential: js.String = js.native
}

object RTCIceServer extends js.Object {
}

class mozwebkitRTCPeerConnection protected () extends webkitRTCPeerConnection {
  def this(settings: webkitRTCPeerConnectionConfig, constraints: RTCMediaConstraints = ???) = this()
}

object mozwebkitRTCPeerConnection extends js.Object {
}

class webkitwebkitRTCPeerConnection protected () extends webkitRTCPeerConnection {
  def this(settings: webkitRTCPeerConnectionConfig, constraints: RTCMediaConstraints = ???) = this()
}

object webkitwebkitRTCPeerConnection extends js.Object {
}

trait RTCOptionalMediaConstraint extends js.Object {
  val DtlsSrtpKeyAgreement: js.Boolean = js.native
  val RtpDataChannels: js.Boolean = js.native
}

trait RTCMediaConstraints extends js.Object {
  val mandatory: RTCMediaOfferConstraints = js.native
  val optional: js.Array[RTCOptionalMediaConstraint] = js.native
}

trait RTCMediaOfferConstraints extends js.Object {
  var OfferToReceiveAudio: js.Boolean = js.native
  var OfferToReceiveVideo: js.Boolean = js.native
}

trait RTCSessionDescriptionInit extends js.Object {
  var `type`: js.String = js.native
  var sdp: js.String = js.native
}

class RTCSessionDescription protected () extends js.Object {
  def this(descriptionInitDict: RTCSessionDescriptionInit = ???) = this()
  var `type`: js.String = js.native
  var sdp: js.String = js.native
}

object RTCSessionDescription extends js.Object {
}

trait RTCDataChannelInit extends js.Object {
  var ordered: js.Boolean = js.native
  var maxPacketLifeTime: js.Number = js.native
  var maxRetransmits: js.Number = js.native
  var protocol: js.String = js.native
  var negotiated: js.Boolean = js.native
  var id: js.Number = js.native
}

trait RTCMessageEvent extends js.Object {
  var data: js.Any = js.native
}

class RTCDataChannel extends EventTarget {
  var label: js.String = js.native
  var reliable: js.Boolean = js.native
  var readyState: js.String = js.native
  var bufferedAmount: js.Number = js.native
  var binaryType: js.String = js.native
  var onopen: js.Function1[Event, _] = js.native
  var onerror: js.Function1[Event, _] = js.native
  var onclose: js.Function1[Event, _] = js.native
  var onmessage: js.Function1[RTCMessageEvent, _] = js.native
  def close(): Unit = js.native
  def send(data: js.String): Unit = js.native
}

object RTCDataChannel extends js.Object {
}

class RTCDataChannelEvent protected () extends Event {
  def this(eventInitDict: RTCDataChannelEventInit) = this()
  var channel: RTCDataChannel = js.native
}

object RTCDataChannelEvent extends js.Object {
}

trait RTCIceCandidateEvent extends Event {
  var candidate: RTCIceCandidate = js.native
}

trait RTCMediaStreamEvent extends Event {
  var stream: MediaStream = js.native
}

trait EventInit extends js.Object {
}

trait RTCDataChannelEventInit extends EventInit {
  var channel: RTCDataChannel = js.native
}

trait RTCStatsReport extends js.Object {
  def stat(id: js.String): js.String = js.native
}


class webkitRTCPeerConnection protected () extends js.Object {
  def this(configuration: RTCConfiguration, constraints: RTCMediaConstraints = ???) = this()
  def createOffer(successCallback: RTCSessionDescriptionCallback, failureCallback: webkitRTCPeerConnectionErrorCallback = ???, constraints: RTCMediaConstraints = ???): Unit = js.native
  def createAnswer(successCallback: RTCSessionDescriptionCallback, failureCallback: webkitRTCPeerConnectionErrorCallback = ???, constraints: RTCMediaConstraints = ???): Unit = js.native
  def setLocalDescription(description: RTCSessionDescription, successCallback: RTCVoidCallback = ???, failureCallback: webkitRTCPeerConnectionErrorCallback = ???): Unit = js.native
  var localDescription: RTCSessionDescription = js.native
  def setRemoteDescription(description: RTCSessionDescription, successCallback: RTCVoidCallback = ???, failureCallback: webkitRTCPeerConnectionErrorCallback = ???): Unit = js.native
  var remoteDescription: RTCSessionDescription = js.native
  var signalingState: js.String = js.native
  def updateIce(configuration: RTCConfiguration = ???, constraints: RTCMediaConstraints = ???): Unit = js.native
  def addIceCandidate(candidate: RTCIceCandidate): Unit = js.native
  var iceGatheringState: js.String = js.native
  var iceConnectionState: js.String = js.native
  def getLocalStreams(): js.Array[MediaStream] = js.native
  def getRemoteStreams(): js.Array[MediaStream] = js.native
  def createDataChannel(label: js.String = ???, dataChannelDict: RTCDataChannelInit = ???): RTCDataChannel = js.native
  var ondatachannel: js.Function1[Event, _] = js.native
  def addStream(stream: MediaStream, constraints: RTCMediaConstraints = ???): Unit = js.native
  def removeStream(stream: MediaStream): Unit = js.native
  def close(): Unit = js.native
  var onnegotiationneeded: js.Function1[Event, _] = js.native
  var onconnecting: js.Function1[Event, _] = js.native
  var onopen: js.Function1[Event, _] = js.native
  var onaddstream: js.Function1[RTCMediaStreamEvent, _] = js.native
  var onremovestream: js.Function1[RTCMediaStreamEvent, _] = js.native
  var onstatechange: js.Function1[Event, _] = js.native
  var onicechange: js.Function1[Event, _] = js.native
  var onicecandidate: js.Function1[RTCIceCandidateEvent, _] = js.native
  var onidentityresult: js.Function1[Event, _] = js.native
  var onsignalingstatechange: js.Function1[Event, _] = js.native
  var getStats: js.Function2[RTCStatsCallback, webkitRTCPeerConnectionErrorCallback, _] = js.native
}

object webkitRTCPeerConnection extends js.Object {
}

class RTCIceCandidate protected () extends js.Object {
  def this(candidateInitDict: RTCIceCandidate = ???) = this()
  var candidate: js.String = js.native
  var sdpMid: js.String = js.native
  var sdpMLineIndex: js.Number = js.native
}

object RTCIceCandidate extends js.Object {
}

class RTCIceCandidateInit extends js.Object {
  var candidate: js.String = js.native
  var sdpMid: js.String = js.native
  var sdpMLineIndex: js.Number = js.native
}

object RTCIceCandidateInit extends js.Object {
}

class PeerConnectionIceEvent extends js.Object {
  var peer: webkitRTCPeerConnection = js.native
  var candidate: RTCIceCandidate = js.native
}

object PeerConnectionIceEvent extends js.Object {
}

class webkitRTCPeerConnectionConfig extends js.Object {
  var iceServers: js.Array[RTCIceServer] = js.native
}

object webkitRTCPeerConnectionConfig extends js.Object {
}
