{ sources ? import ./nix/sources.nix, pkgs ? import sources.nixpkgs { } }:
let
  cleanUp = pkgs.writeShellScriptBin "clean-up" ''
    set -euxo pipefail
    rm -rvf .bloop project/.bloop .metals project/.metals target project/target project/project modules/*/target .direnv
  '';
  java = pkgs.openjdk8;
  sbt = pkgs.sbt.override {
    jre = java;
  };
  coursier = pkgs.coursier.override {
    jre = java;
  };
in
pkgs.mkShell {
  buildInputs = [
    sbt
    java
    coursier
    cleanUp
  ];
}
